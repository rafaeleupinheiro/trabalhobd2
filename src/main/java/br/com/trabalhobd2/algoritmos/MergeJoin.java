package br.com.trabalhobd2.algoritmos;

import br.com.trabalhobd2.daos.CodigoNCMDAO;
import br.com.trabalhobd2.daos.ProdutoDAO;
import br.com.trabalhobd2.entidades.*;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    Relacao relacaoProduto = new Relacao();
    Relacao relacaoNCM = new Relacao();
    long tempoInicial = System.currentTimeMillis();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    CodigoNCMDAO fabricanteDAO = new CodigoNCMDAO();
    resultado = new ArrayList<>();

    try {
      produtos = produtoDAO.getProdutos();
      codigoNCMs = fabricanteDAO.getCodigoNCM();
      ordenaListaProduto();
      ordenaListaNCM();

      while (!relacaoProduto.ePosicaoFinal() && !relacaoNCM.ePosicaoFinal()) {
        Produto produto = produtos.get(relacaoProduto.getPosicao());
        CodigoNCM codigoNCM = codigoNCMs.get(relacaoNCM.getPosicao());
        if (Integer.parseInt(produto.getCodNCM()) == Integer.parseInt(codigoNCM.getCodNCM())) {
          resultado.add(new ProdutoNCM(produto, codigoNCM));
          relacaoProduto.avancar(produtos.size());
          relacaoNCM.avancar(codigoNCMs.size());
        } else if (Integer.parseInt(produto.getCodNCM()) < Integer.parseInt(codigoNCM.getCodNCM()))
          relacaoProduto.avancar(produtos.size());
        else
          relacaoNCM.avancar(codigoNCMs.size());
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

  public void ordenaListaProduto() {
    Collections.sort(produtos, new Comparator<Object>() {
      public int compare(Object o1, Object o2) {
        Produto p1 = (Produto) o1;
        Produto p2 = (Produto) o2;
        return Integer.parseInt(p1.getCodNCM()) < Integer.parseInt(p2.getCodNCM()) ? -1 : (Integer.parseInt(p1.getCodNCM()) > Integer.parseInt(p2.getCodNCM()) ? +1 : 0);
      }
    });
  }

  public void ordenaListaNCM() {
    Collections.sort(codigoNCMs, new Comparator<Object>() {
      public int compare(Object o1, Object o2) {
        CodigoNCM p1 = (CodigoNCM) o1;
        CodigoNCM p2 = (CodigoNCM) o2;
        return Integer.parseInt(p1.getCodNCM()) < Integer.parseInt(p2.getCodNCM()) ? -1 : (Integer.parseInt(p1.getCodNCM()) > Integer.parseInt(p2.getCodNCM()) ? +1 : 0);
      }
    });
  }
}