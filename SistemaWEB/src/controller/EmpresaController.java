package controller;

import model.Empresa;
import model.Funcionario;

public class EmpresaController {
	public void adicionarFuncionario(Empresa empresa, Funcionario funcionario) {
		if(empresa != null && funcionario != null) {
			empresa.adicionarFuncionario(funcionario);
		}
	}
	
	public void removerFuncionario(Empresa empresa, Funcionario funcionario) {
		if(empresa != null && funcionario != null) {
			empresa.removerFuncionario(funcionario);
		}
	}
	
	public void nextDay(Empresa empresa) {
		empresa.nextDay();
	}
}
