package br.com.trabalhobd2.entidades;

import br.com.trabalhobd2.app.Application;

import java.util.List;

public class ListarTabela {
  private static List<ProdutoFabricante> produtoFabricantes;

  public ListarTabela(List<ProdutoFabricante> produtoFabricantes) {
    this.produtoFabricantes = produtoFabricantes;
  }

  public void pesquisar() {
    Application.modelo.setNumRows(0);
    for (ProdutoFabricante produtoFabricante : produtoFabricantes) {
      Application.modelo.addRow(new Object[]{produtoFabricante.getProduto().getCodProduto(),
          produtoFabricante.getProduto().getDescricao(),
          produtoFabricante.getProduto().getCodFabricante(),
          produtoFabricante.getProduto().getCodEAN(),
          produtoFabricante.getProduto().getNumRegMS(),
          produtoFabricante.getProduto().getCodNCM(),
          produtoFabricante.getProduto().getPrcFaricante(),
          produtoFabricante.getProduto().getPrcVenda(),
          produtoFabricante.getFabricante().getCodFabricante(),
          produtoFabricante.getFabricante().getDescricao()});
    }
  }

  public void inserir(ProdutoFabricante produtoFabricante) {
    produtoFabricantes.add(produtoFabricante);
  }

  public void removeAllTabela() {
    Application.modelo.setNumRows(0);
    produtoFabricantes.clear();
    Application.txfNaoProcessado.setText("");
    //appConfig.totalTabela(produtoFabricantes.size());
  }

  public List<ProdutoFabricante> getListaNotas() {
    return produtoFabricantes;
  }
}
