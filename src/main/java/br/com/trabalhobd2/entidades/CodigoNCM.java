package br.com.trabalhobd2.entidades;

public class CodigoNCM {
  private String codNCM;
  private String descricao;

  public CodigoNCM(String codNCM, String descricao) {
    this.codNCM = codNCM;
    this.descricao = descricao;
  }

  public CodigoNCM() {
  }

  public String getCodNCM() {
    return codNCM;
  }

  public void setCodNCM(String codNCM) {
    this.codNCM = codNCM;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
