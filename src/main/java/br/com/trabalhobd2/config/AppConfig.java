package br.com.trabalhobd2.config;

import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.conexao.Conexao;

public class AppConfig {
    private static AppConfig uniqueInstance = new AppConfig();

    public static AppConfig getInstance() {
        return uniqueInstance;
    }

    public void estado(int x) {
        switch (x) {
            case 1:
                Application.txfServidor.setEditable(true);
                Application.txfInstancia.setEditable(true);
                Application.txfPorta.setEditable(true);
                Application.txfBanco.setEditable(true);
                Application.txfUsuario.setEditable(true);
                Application.txfSenha.setEditable(true);
                Application.btnConectar.setEnabled(true);
                Application.btnDesconectar.setEnabled(false);
                Application.txfNaoProcessado.setText("");
                Application.btnSelecionarAlgoritmo.setEnabled(false);
                Application.comboBox.setEnabled(false);
                break;

            case 2:
                Application.txfServidor.setEditable(false);
                Application.txfInstancia.setEditable(false);
                Application.txfPorta.setEditable(false);
                Application.txfBanco.setEditable(false);
                Application.txfUsuario.setEditable(false);
                Application.txfSenha.setEditable(false);
                Application.btnConectar.setEnabled(false);
                Application.btnDesconectar.setEnabled(true);
                Application.btnSelecionarAlgoritmo.setEnabled(true);
                Application.comboBox.setEnabled(true);
                break;

            case 3:
                Application.txfServidor.setEditable(false);
                Application.txfInstancia.setEditable(false);
                Application.txfPorta.setEditable(false);
                Application.txfBanco.setEditable(false);
                Application.txfUsuario.setEditable(false);
                Application.txfSenha.setEditable(false);
                Application.btnConectar.setEnabled(false);
                Application.btnDesconectar.setEnabled(false);
                break;

            default:
                break;
        }
    }

    @SuppressWarnings("deprecation")
    public void preencheCamposSql() {
        Conexao.getInstance().setSERVIDOR(Application.txfServidor.getText());
        Conexao.getInstance().setPORTA(Application.txfPorta.getText());
        Conexao.getInstance().setINSTANCIA(Application.txfInstancia.getText());
        Conexao.getInstance().setBANCO(Application.txfBanco.getText());
        Conexao.getInstance().setUSUARIO(Application.txfUsuario.getText());
        Conexao.getInstance().setSENHA(Application.txfSenha.getText());
    }

  /*public void totalTabela(int total) {
    Application.lblTotal.setText("Notas a serem importadas: " + total);
  }*/
}
