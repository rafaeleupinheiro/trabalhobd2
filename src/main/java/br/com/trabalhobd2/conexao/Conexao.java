package br.com.trabalhobd2.conexao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.PooledConnection;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Conexao {
  private ComboPooledDataSource pool = null;
  private static Conexao uniqueInstance = new Conexao();

  private String SERVIDOR = "";
  private String PORTA = "";
  private String BANCO = "";
  private String USUARIO = "";
  private String SENHA = "";
  private String INSTANCIA = "";
  private String instanciaAux = "";

  private Conexao() {
  }

  public static Conexao getInstance() {
    return uniqueInstance;
  }

  public PooledConnection conn() throws ClassNotFoundException, SQLException, PropertyVetoException {
    if (pool == null) {
      instanciaAux = ";instance=" + INSTANCIA;
      pool = new ComboPooledDataSource();
      pool.setDriverClass("net.sourceforge.jtds.jdbc.Driver");
      pool.setJdbcUrl("jdbc:jtds:sqlserver://" + SERVIDOR + ":" + PORTA + "/" + BANCO + ""
          + instanciaAux);
      pool.setUser(USUARIO);
      pool.setPassword(SENHA);
      pool.setMinPoolSize(5);
      pool.setAcquireIncrement(5);
      pool.setMaxPoolSize(20);
    }
    return pool.getConnectionPoolDataSource().getPooledConnection();
  }

  public void testaConn() throws ClassNotFoundException, SQLException, PropertyVetoException {
    pool = null;
    conn();
    pool.setPreferredTestQuery("SELECT 1");
  }

  public void poolFecha() {
    pool = null;
  }

  public String getSERVIDOR() {
    return SERVIDOR;
  }

  public void setSERVIDOR(String sERVIDOR) {
    SERVIDOR = sERVIDOR;
  }

  public String getBANCO() {
    return BANCO;
  }

  public void setBANCO(String bANCO) {
    BANCO = bANCO;
  }

  public String getUSUARIO() {
    return USUARIO;
  }

  public void setUSUARIO(String uSUARIO) {
    USUARIO = uSUARIO;
  }

  public String getSENHA() {
    return SENHA;
  }

  public void setSENHA(String sENHA) {
    SENHA = sENHA;
  }

  public String getINSTANCIA() {
    return INSTANCIA;
  }

  public void setINSTANCIA(String iNSTANCIA) {
    INSTANCIA = iNSTANCIA;
  }

  public String getInstanciaAux() {
    return instanciaAux;
  }

  public void setInstanciaAux(String instanciaAux) {
    this.instanciaAux = instanciaAux;
  }

  public String getPORTA() {
    return PORTA;
  }

  public void setPORTA(String PORTA) {
    this.PORTA = PORTA;
  }
}
