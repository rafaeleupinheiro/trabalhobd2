package br.com.trabalhobd2.entidades;

public class ProdutoFabricante {
    private Produto produto;
    private Fabricante fabricante;

    public ProdutoFabricante(Produto produto, Fabricante fabricante) {
        this.produto = produto;
        this.fabricante = fabricante;
    }

    public ProdutoFabricante() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
