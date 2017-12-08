package model;

import services.FactoryEmpresa;

public class User {
	/**
	 * Constante criada para evitar 'typos' quanto aos atributos das páginas com
	 * relação ao username. <br>
	 * Como, por exemplo, digitar 'unome' em vez de 'uname'.
	 */
	public static final String USER_NAME = "uname";
	/**
	 * Constante criada para evitar 'typos' quanto aos atributos das páginas com relação 
	 * à senha do usuário.
	 */
	public static final String USER_PWD = "upwd";
	
	private String uname;
	private String upwd;
	private Empresa empresa;
	
	public User() {
		empresa = new FactoryEmpresa().getEmpresa();
		uname = "";
		upwd = "";
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) throws IllegalArgumentException {
		if(uname == null || uname == "") {
			throw new IllegalArgumentException("Nome de usuário não pode estar vazio");
		}
		this.uname = uname.toLowerCase();
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) throws IllegalArgumentException {
		if(upwd == null || upwd == "") {
			throw new IllegalArgumentException("Senha de usuário não pode estar vazio");
		}
		this.upwd = upwd;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
