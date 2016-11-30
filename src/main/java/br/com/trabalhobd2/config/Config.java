package br.com.trabalhobd2.config;

public class Config {
	private String servidor;
	private String instancia;
	private String porta;
	private String banco;
	private String usuario;
	private String senha;

	public Config() {

	}

	public Config(String servidor, String instancia, String porta,
			String banco, String usuario, String senha) {
		super();
		this.servidor = servidor;
		this.instancia = instancia;
		this.porta = porta;
		this.banco = banco;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

}
