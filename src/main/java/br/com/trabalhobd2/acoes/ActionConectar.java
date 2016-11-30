package br.com.trabalhobd2.acoes;

import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.conexao.Conexao;
import br.com.trabalhobd2.config.AppConfig;
import br.com.trabalhobd2.config.ConfigDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionConectar implements ActionListener {

  @SuppressWarnings("deprecation")
  public void actionPerformed(ActionEvent arg0) {
    ConfigDao.setConfig(Application.txfServidor.getText(), Application.txfInstancia.getText(),
        Application.txfPorta.getText(), Application.txfBanco.getText(), Application.txfUsuario.getText(),
        Application.txfSenha.getText());

    AppConfig.getInstance().preencheCamposSql();
    try {
      Conexao.getInstance().testaConn();
      AppConfig.getInstance().estado(2);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Falha na conexão!!\n" + e.getMessage(), "Erro",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
