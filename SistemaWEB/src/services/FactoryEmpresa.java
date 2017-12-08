package services;

import java.util.ArrayList;

import model.Empresa;
import model.Funcionario;

public class FactoryEmpresa {
	public Empresa getEmpresa() {
		int[] tmp = new int[6];
		Empresa empresa = new Empresa();
		empresa.setSaldo(10000);
		empresa.setId( (long) (Math.random() * 1250300500) );
		empresa.setFuncionarios(new ArrayList<Funcionario>());
		empresa.setQtdAtivos(tmp);
		empresa.setDiasPassados(0L);
		
		return empresa;
	}
	
	public static void main(String[] args) {
		Empresa e = new FactoryEmpresa().getEmpresa();
		
		System.out.println(e.getId() + " " + e.getSaldo());
	}
}
