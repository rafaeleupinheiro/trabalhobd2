package br.com.trabalhobd2.entidades;

import br.com.trabalhobd2.app.Application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExibirInformacoes {
  private String algoritmo;
  private int numeroProdutos;
  private int numeroNCMs;
  private int numeroRegistros;
  private long tempo;

  public ExibirInformacoes(String algoritmo, int numeroProdutos, int numeroNCMs, int numeroRegistros, long tempo) {
    this.algoritmo = algoritmo;
    this.numeroProdutos = numeroProdutos;
    this.numeroNCMs = numeroNCMs;
    this.numeroRegistros = numeroRegistros;
    this.tempo = tempo;
  }

  public void setMengasem() {
    Application.txfNaoProcessado.setText("O algoritmo " + algoritmo + " executou em 00:" + new SimpleDateFormat("mm:ss.SSS").format(new Date(tempo)) + "\n" +
        "A tabela de Produtos contém " + numeroProdutos + " registros\n" +
        "A tabela de Ncms contém " + numeroNCMs + " registros\n" +
        "A junção contém " + numeroRegistros + " registros");
  }
}
