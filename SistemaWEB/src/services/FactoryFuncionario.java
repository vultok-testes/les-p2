package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.Funcionario;

public class FactoryFuncionario {
	private String[] nomes = {"Fulano", "Ciclano", "Beltrano", "Gersiano", 
				"Homer", "Marcus Aurelius", "Maximus Decimus Meridius", "Mike", "John", "Abc123",
				"Zarabatana", "Rufus Quintus"};
	
	public Funcionario getFuncionario() {
		double salarioMinimo = 75;
		double salario = salarioMinimo + (Math.random() * 50);
		double rendimento = salario + (Math.random() * 20);

		salario = round(salario, 3);
		rendimento = round(rendimento, 3);
		
		int num = (int) (Math.random() * nomes.length);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId((long) (Math.random() * 1250300500));
		funcionario.setNome(nomes[num]);
		funcionario.setSalario(salario);
		funcionario.setRendimentoMaximo(rendimento);
		funcionario.setTaxaRendimento(1);

		return funcionario;
	}
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Funcionario f = new FactoryFuncionario().getFuncionario();
			System.out.println("{\"Nome\": \"" + f.getNome() + "\", \"Salario\": \"" + f.getSalario() + 
					"\", \"Rendimento\" : \"" + f.getRendimentoMaximo() + "\", \"TR\": \"" + f.getTaxaRendimento() + "\"}");
		}
	}
}
