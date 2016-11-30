package br.com.trabalhobd2.entidades;

public class Relacao {
  public final int ENDPOS = -1;
  public int posicao = 0;

  public int getPosicao() {
    return posicao;
  }

  public boolean avancar(int tamanho) {
    if (posicao == tamanho - 1 || posicao == ENDPOS) {
      posicao = ENDPOS;
      return false;
    }
    posicao++;
    return true;
  }

  public boolean ePosicaoFinal() {
    return posicao == ENDPOS;
  }
}
