package br.com.trabalhobd2.entidades;

public class Fabricante {
    private int codFabricante;
    private String descricao;

    public Fabricante(int codFabricante, String descricao) {
        this.codFabricante = codFabricante;
        this.descricao = descricao;
    }

    public Fabricante() {
    }

    public int getCodFabricante() {
        return codFabricante;
    }

    public void setCodFabricante(int codFabricante) {
        this.codFabricante = codFabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
