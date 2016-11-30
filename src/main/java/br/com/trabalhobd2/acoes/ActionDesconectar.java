package br.com.trabalhobd2.acoes;

import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.conexao.Conexao;
import br.com.trabalhobd2.config.AppConfig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionDesconectar implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    Conexao.getInstance().poolFecha();
    AppConfig.getInstance().estado(1);
    Application.modelo.setNumRows(0);
  }

}
