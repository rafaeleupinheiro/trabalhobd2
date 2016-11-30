package br.com.trabalhobd2.entidades;

public class Produto {
  private int codProduto;
  private String descricao;
  private String codEAN;
  private String numRegMS;
  private String codNCM;
  private float prcFaricante;
  private float prcVenda;

  public Produto(int codProduto, String descricao, String codEAN, String numRegMS, String codNCM, float prcFaricante, float prcVenda) {
    this.codProduto = codProduto;
    this.descricao = descricao;
    this.codEAN = codEAN;
    this.numRegMS = numRegMS;
    this.codNCM = codNCM;
    this.prcFaricante = prcFaricante;
    this.prcVenda = prcVenda;
  }

  public Produto() {
  }

  public int getCodProduto() {
    return codProduto;
  }

  public void setCodProduto(int codProduto) {
    this.codProduto = codProduto;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCodEAN() {
    return codEAN;
  }

  public void setCodEAN(String codEAN) {
    this.codEAN = codEAN;
  }

  public String getNumRegMS() {
    return numRegMS;
  }

  public void setNumRegMS(String numRegMS) {
    this.numRegMS = numRegMS;
  }

  public String getCodNCM() {
    return codNCM;
  }

  public void setCodNCM(String codNCM) {
    this.codNCM = codNCM;
  }

  public float getPrcFaricante() {
    return prcFaricante;
  }

  public void setPrcFaricante(float prcFaricante) {
    this.prcFaricante = prcFaricante;
  }

  public float getPrcVenda() {
    return prcVenda;
  }

  public void setPrcVenda(float prcVenda) {
    this.prcVenda = prcVenda;
  }
}
