package br.com.trabalhobd2.app;

import br.com.trabalhobd2.acoes.ActionConectar;
import br.com.trabalhobd2.acoes.ActionDesconectar;
import br.com.trabalhobd2.acoes.ActionEnter;
import br.com.trabalhobd2.acoes.ActionSelecionarAlgoritmo;
import br.com.trabalhobd2.config.AppConfig;
import br.com.trabalhobd2.config.Config;
import br.com.trabalhobd2.config.ConfigDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Application extends JFrame {
  private static final long serialVersionUID = 1L;
  public static JLabel lblServidor;
  public static JLabel lblInstancia;
  public static JLabel lblPorta;
  public static JLabel lblBanco;
  public static JLabel lblUsuario;
  public static JLabel lblSenha;
  public static JLabel lblAlgoritmo;

  public static JTextField txfServidor;
  public static JTextField txfInstancia;
  public static JTextField txfPorta;
  public static JTextField txfBanco;
  public static JTextField txfUsuario;
  public static JPasswordField txfSenha;

  public static JButton btnConectar;
  public static JButton btnDesconectar;
  public static JButton btnSelecionarAlgoritmo;

  public static JTable tabela;
  public static JScrollPane barraRolagemTabela;
  public static JScrollPane barraRolagemTexto;
  public static JTextPane txfNaoProcessado;

  public static JPanel painelConfiguracao;
  public static JPanel painelImportacao;
  public static JPanel panelProcesso;

  public static DefaultTableModel modelo = new DefaultTableModel();
  public static JComboBox comboBox;

  String[] algoritmos = {"Block Nested-Loop Join", "Merge Join", "Hash Join"};

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Application frame = new Application();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public Application() {
    Config config = ConfigDao.getConfig();

    setTitle("inFarma - Importação de Notas XML");
    // setResizable(false);
    // setBounds(100, 100, 1344, 816);
    // setLocationRelativeTo(null);
    this.setExtendedState(MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    painelConfiguracao = new JPanel();
    painelConfiguracao.setBounds(0, 0, 1365, 144);
    painelConfiguracao.setBorder(new TitledBorder(UIManager
        .getBorder("TitledBorder.border"), "Configura\u00E7\u00F5es",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    getContentPane().add(painelConfiguracao);
    painelConfiguracao.setLayout(null);

    lblServidor = new JLabel("Servidor");
    lblServidor.setHorizontalAlignment(SwingConstants.RIGHT);
    lblServidor.setBounds(19, 45, 56, 14);
    painelConfiguracao.add(lblServidor);

    txfServidor = new JTextField();
    txfServidor.setBounds(85, 42, 108, 20);
    txfServidor.addKeyListener(new ActionEnter());
    txfServidor.setText(config.getServidor());
    painelConfiguracao.add(txfServidor);
    txfServidor.setColumns(10);

    lblInstancia = new JLabel("Inst\u00E2ncia");
    lblInstancia.setHorizontalAlignment(SwingConstants.RIGHT);
    lblInstancia.setBounds(203, 45, 66, 14);
    painelConfiguracao.add(lblInstancia);

    txfInstancia = new JTextField();
    txfInstancia.setBounds(279, 42, 108, 20);
    txfInstancia.setText(config.getInstancia());
    painelConfiguracao.add(txfInstancia);
    txfInstancia.setColumns(10);

    lblPorta = new JLabel("Porta");
    lblPorta.setHorizontalAlignment(SwingConstants.RIGHT);
    lblPorta.setBounds(409, 45, 47, 14);
    painelConfiguracao.add(lblPorta);

    txfPorta = new JTextField();
    txfPorta.setBounds(466, 42, 108, 20);
    txfPorta.setText(config.getPorta());
    painelConfiguracao.add(txfPorta);
    txfPorta.setColumns(10);

    btnConectar = new JButton("Conectar");
    btnConectar.setBounds(592, 41, 120, 23);
    btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnConectar.addActionListener(new ActionConectar());
    painelConfiguracao.add(btnConectar);

    lblBanco = new JLabel("Banco");
    lblBanco.setHorizontalAlignment(SwingConstants.RIGHT);
    lblBanco.setBounds(19, 76, 56, 14);
    painelConfiguracao.add(lblBanco);

    txfBanco = new JTextField();
    txfBanco.setBounds(85, 73, 108, 20);
    txfBanco.setText(config.getBanco());
    painelConfiguracao.add(txfBanco);
    txfBanco.setColumns(10);

    lblUsuario = new JLabel("Usu\u00E1rio");
    lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
    lblUsuario.setBounds(203, 76, 66, 14);
    painelConfiguracao.add(lblUsuario);

    txfUsuario = new JTextField();
    txfUsuario.setBounds(279, 73, 108, 20);
    txfUsuario.setText(config.getUsuario());
    txfUsuario.setColumns(10);
    painelConfiguracao.add(txfUsuario);

    lblSenha = new JLabel("Senha");
    lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
    lblSenha.setBounds(405, 76, 51, 14);
    painelConfiguracao.add(lblSenha);

    btnDesconectar = new JButton("Desconectar");
    btnDesconectar.setBounds(592, 72, 120, 23);
    btnDesconectar.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnDesconectar.addActionListener(new ActionDesconectar());

    txfSenha = new JPasswordField();
    txfSenha.setBounds(468, 73, 106, 20);
    txfSenha.setText(config.getSenha());
    painelConfiguracao.add(txfSenha);
    painelConfiguracao.add(btnDesconectar);

    lblAlgoritmo = new JLabel("Algoritmo");
    lblAlgoritmo.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblAlgoritmo.setBounds(813, 55, 58, 20);
    painelConfiguracao.add(lblAlgoritmo);

    comboBox = new JComboBox(algoritmos);
    comboBox.setBounds(901, 53, 170, 23);
    comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
    painelConfiguracao.add(comboBox);

    btnSelecionarAlgoritmo = new JButton("Selecionar");
    btnSelecionarAlgoritmo.setFont(new Font("Tahoma", Font.PLAIN, 11));
    btnSelecionarAlgoritmo.setBounds(1109, 52, 113, 25);
    btnSelecionarAlgoritmo.addActionListener(new ActionSelecionarAlgoritmo());
    painelConfiguracao.add(btnSelecionarAlgoritmo);

    painelImportacao = new JPanel();
    painelImportacao.setBounds(0, 142, 1365, 343);
    painelImportacao.setBorder(new TitledBorder(null,
        "Resultado da Consulta", TitledBorder.LEADING, TitledBorder.TOP,
        null, null));
    getContentPane().add(painelImportacao);
    painelImportacao.setLayout(null);

    criaJTable();
    barraRolagemTabela = new JScrollPane(tabela);
    barraRolagemTabela.setBounds(13, 21, 1342, 311);
    painelImportacao.add(barraRolagemTabela);

    panelProcesso = new JPanel();
    panelProcesso.setBounds(0, 484, 1365, 220);
    panelProcesso.setBorder(new TitledBorder(UIManager
        .getBorder("TitledBorder.border"),
        "Informações", TitledBorder.LEADING,
        TitledBorder.TOP, null, null));
    getContentPane().add(panelProcesso);
    panelProcesso.setLayout(null);

    txfNaoProcessado = new JTextPane();
    barraRolagemTexto = new JScrollPane(txfNaoProcessado);
    barraRolagemTexto.setBounds(10, 22, 1345, 189);
    txfNaoProcessado.setEditable(false);
    panelProcesso.add(barraRolagemTexto);

    AppConfig.getInstance().estado(1);
  }

  private void criaJTable() {
    modelo = new DefaultTableModel() {
      private static final long serialVersionUID = 1L;

      public boolean isCellEditable(int row, int col) {
        return false;
      }
    };
    tabela = new JTable(modelo);
    modelo.addColumn("CodProduto");
    modelo.addColumn("Descricao");
    modelo.addColumn("CodEAN");
    modelo.addColumn("NumRegMS");
    modelo.addColumn("CodNCM");
    modelo.addColumn("PrcFabricante");
    modelo.addColumn("PrcVenda");
    modelo.addColumn("CodNCM");
    modelo.addColumn("Descricao");
    //tabela.getColumnModel().getColumn(0).setPreferredWidth(5);
    tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
    tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
    tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
    tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
    tabela.getColumnModel().getColumn(8).setPreferredWidth(300);
    //tabela.getColumnModel().getColumn(2).setPreferredWidth(400);
    //tabela.getColumnModel().getColumn(3).setPreferredWidth(50);*/
    // tabela.addMouseListener(new ActionSelecionarTabela());
  }
}
