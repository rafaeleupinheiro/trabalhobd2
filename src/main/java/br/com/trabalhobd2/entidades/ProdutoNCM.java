package br.com.trabalhobd2.entidades;

public class ProdutoNCM {
  private Produto produto;
  private CodigoNCM codigoNCM;

  public ProdutoNCM(Produto produto, CodigoNCM codigoNCM) {
    this.produto = produto;
    this.codigoNCM = codigoNCM;
  }

  public ProdutoNCM() {
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public CodigoNCM getFabricante() {
    return codigoNCM;
  }

  public void setFabricante(CodigoNCM codigoNCM) {
    this.codigoNCM = codigoNCM;
  }
}
