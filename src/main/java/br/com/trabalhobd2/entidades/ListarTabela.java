package br.com.trabalhobd2.entidades;

import br.com.trabalhobd2.app.Application;

import java.util.List;

public class ListarTabela {
  private static List<ProdutoNCM> produtoNCMs;

  public ListarTabela(List<ProdutoNCM> produtoNCMs) {
    this.produtoNCMs = produtoNCMs;
  }

  public void pesquisar() {
    Application.modelo.setNumRows(0);
    for (ProdutoNCM produtoNCM : produtoNCMs) {
      Application.modelo.addRow(new Object[]{produtoNCM.getProduto().getCodProduto(),
          produtoNCM.getProduto().getDescricao(),
          produtoNCM.getProduto().getCodEAN(),
          produtoNCM.getProduto().getNumRegMS(),
          produtoNCM.getProduto().getCodNCM(),
          produtoNCM.getProduto().getPrcFaricante(),
          produtoNCM.getProduto().getPrcVenda(),
          produtoNCM.getFabricante().getCodNCM(),
          produtoNCM.getFabricante().getDescricao()});
    }
  }

  public void inserir(ProdutoNCM produtoFabricante) {
    produtoNCMs.add(produtoFabricante);
  }

  public void removeAllTabela() {
    Application.modelo.setNumRows(0);
    produtoNCMs.clear();
    Application.txfNaoProcessado.setText("");
    //appConfig.totalTabela(produtoFabricantes.size());
  }

  public List<ProdutoNCM> getListaNotas() {
    return produtoNCMs;
  }
}
