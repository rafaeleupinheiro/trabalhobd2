package br.com.trabalhobd2.acoes;

import br.com.trabalhobd2.algoritmos.HashJoin;
import br.com.trabalhobd2.app.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSelecionarAlgoritmo implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    int tipoAlgoritmo = Application.comboBox.getSelectedIndex();
    switch (tipoAlgoritmo) {
      case 0:
        break;
      case 1:
        break;
      case 2:
        HashJoin hashJoin = new HashJoin();
        hashJoin.iniciar();
        break;
    }
  }
}
