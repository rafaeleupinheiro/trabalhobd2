package br.com.trabalhobd2.algoritmos;

import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.daos.CodigoNCMDAO;
import br.com.trabalhobd2.daos.ProdutoDAO;
import br.com.trabalhobd2.entidades.*;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeJoin {
  List<Produto> produtos = null;
  List<CodigoNCM> codigoNCMs = null;
  List<ProdutoNCM> resultado = null;

  public void iniciar() {
    mergeJoin();
    ListarTabela listarTabela = new ListarTabela(resultado);
    listarTabela.pesquisar();
  }

  public void mergeJoin() {
    long tempoInicial = System.currentTimeMillis();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    CodigoNCMDAO fabricanteDAO = new CodigoNCMDAO();
    resultado = new ArrayList<>();

    try {
      produtos = produtoDAO.getProdutos();
      codigoNCMs = fabricanteDAO.getCodigoNCM();
      int indiceProduto = 0;
      int indiceNCM = 0;
      Produto produto = produtos.get(indiceProduto);
      CodigoNCM codigoNCM = codigoNCMs.get(indiceNCM);

      while (Integer.parseInt(produto.getCodNCM()) >= Integer.parseInt(codigoNCM.getCodNCM()) && resultado.size() != codigoNCMs.size()) {
        if (produto.getCodNCM().equals(codigoNCM.getCodNCM())) {
          ProdutoNCM produtoNCM = new ProdutoNCM(produto, codigoNCM);
          produto = produtos.get(++indiceProduto);
        } else {
          if (Integer.parseInt(produto.getCodNCM()) > Integer.parseInt(codigoNCM.getCodNCM())) {
            codigoNCM = codigoNCMs.get(++indiceNCM);
          }
        }
      }
      long tempo = System.currentTimeMillis() - tempoInicial;
      ExibirInformacoes exibirInformacoes = new ExibirInformacoes("Merge Join", produtos.size(), codigoNCMs.size(), resultado.size(), tempo);
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