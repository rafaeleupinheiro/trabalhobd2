package br.com.trabalhobd2.algoritmos;

import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.daos.CodigoNCMDAO;
import br.com.trabalhobd2.daos.ProdutoDAO;
import br.com.trabalhobd2.entidades.*;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockNestedLoopJoin {
  List<Produto> produtos = null;
  List<CodigoNCM> codigoNCMs = null;
  List<ProdutoNCM> resultado = null;

  public void iniciar() {
    hashJoin();
    ListarTabela listarTabela = new ListarTabela(resultado);
    listarTabela.pesquisar();
  }

  public void hashJoin() {
    long tempoInicial = System.currentTimeMillis();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    CodigoNCMDAO fabricanteDAO = new CodigoNCMDAO();
    resultado = new ArrayList<>();

    try {
      produtos = produtoDAO.getProdutos();
      codigoNCMs = fabricanteDAO.getCodigoNCM();

      for (Produto produto : produtos) {
        for (CodigoNCM codigoNCM : codigoNCMs) {
          if (produto.getCodNCM().equals(codigoNCM.getCodNCM())) {
            ProdutoNCM produtoNCM = new ProdutoNCM(produto, codigoNCM);
            resultado.add(produtoNCM);
            break;
          }
        }
      }
      long tempo = System.currentTimeMillis() - tempoInicial;
      ExibirInformacoes exibirInformacoes = new ExibirInformacoes("Block Nested-Loop Join", produtos.size(), codigoNCMs.size(), resultado.size(), tempo);
      exibirInformacoes.setMengasem();
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}