package br.com.trabalhobd2.acoes;

import br.com.trabalhobd2.algoritmos.BlockNestedLoopJoin;
import br.com.trabalhobd2.algoritmos.HashJoin;
import br.com.trabalhobd2.algoritmos.MergeJoin;
import br.com.trabalhobd2.app.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSelecionarAlgoritmo implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    int tipoAlgoritmo = Application.comboBox.getSelectedIndex();
    switch (tipoAlgoritmo) {
      case 0:
        BlockNestedLoopJoin blockNestedLoopJoin = new BlockNestedLoopJoin();
        blockNestedLoopJoin.iniciar();
        break;
      case 1:
        MergeJoin mergeJoin = new MergeJoin();
        mergeJoin.iniciar();
        break;
      case 2:
        HashJoin hashJoin = new HashJoin();
        hashJoin.iniciar();
        break;
    }
  }
}
