package br.com.trabalhobd2.acoes;

import br.com.trabalhobd2.algoritmos.BlockNestedLoopJoin;
import br.com.trabalhobd2.algoritmos.HashJoin;
import br.com.trabalhobd2.algoritmos.MergeJoin;
import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.config.AppConfig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSelecionarAlgoritmo implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    int tipoAlgoritmo = Application.comboBox.getSelectedIndex();
    switch (tipoAlgoritmo) {
      case 0:
        AppConfig.getInstance().estado(3);
        BlockNestedLoopJoin blockNestedLoopJoin = new BlockNestedLoopJoin();
        blockNestedLoopJoin.iniciar();
        AppConfig.getInstance().estado(2);
        break;
      case 1:
        AppConfig.getInstance().estado(3);
        MergeJoin mergeJoin = new MergeJoin();
        mergeJoin.iniciar();
        AppConfig.getInstance().estado(2);
        break;
      case 2:
        AppConfig.getInstance().estado(3);
        HashJoin hashJoin = new HashJoin();
        hashJoin.iniciar();
        AppConfig.getInstance().estado(2);
        break;
    }
  }
}
