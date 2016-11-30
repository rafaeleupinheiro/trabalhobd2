package br.com.trabalhobd2.acoes;

import br.com.trabalhobd2.config.AppConfig;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionExluirRegistro implements ActionListener {
    AppConfig appConfig = AppConfig.getInstance();
    //ListarTabela listar = ListarTabela.getInstance();

    public void actionPerformed(ActionEvent e) {
        //listar.removeItemTabela();
       // listar.pesquisar();
       // appConfig.totalTabela(listar.getListaNotas().size());
    }

}
