package model;

import events.Event;
import events.EventHandler;

/**
 * Classe contém os dados dos funcionários, como seus atributos.
 * @author elton
 *
 */
public class Funcionario implements EventHandler {
	private long id;
	private String nome;
	/**
	 * Quanto o funcionário custa por dia para empresa
	 */
	private double salario;
	/**
	 * Quanto o funcionário pode gerar de lucro para a empresa, por dia
	 */
	private double rendimentoMaximo;
	/**
	 * Qual a taxa de rendimento do funcionário, o que determina efetivamente o lucro diário.
	 */
	private double taxaRendimento;
	private Event currentEvent;
	
	public static final int SALARIO = 0;
	public static final int MAX_RENDIMENTO = 1;
	public static final int TAXA_RENDIMENTO = 2;
	
	@Override
	public void returnToDefault() {
		currentEvent = null;
	}
	
	@Override
	public void handleEvent(Event e) {
		switch(e.getAtributoAfetado()) {
		case SALARIO:
			salario = salario + e.getFator();
			break;
		case MAX_RENDIMENTO: 
			rendimentoMaximo = rendimentoMaximo + e.getFator();
			break;
		case TAXA_RENDIMENTO:
			taxaRendimento = 1 + e.getFator();
			break;
		}
		
		currentEvent = e;
	}
	
	public String toJson() {
		String json = "{\"nome\": \"" + nome 
				+ "\", \"salario\": \"" + salario
				+ "\", \"rendimento\": \"" + rendimentoMaximo
				+ "\", \"taxa\": \"" + taxaRendimento
				+ "\"}";
		
		return json;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getRendimentoMaximo() {
		return rendimentoMaximo;
	}
	public void setRendimentoMaximo(double rendimentoMaximo) {
		this.rendimentoMaximo = rendimentoMaximo;
	}
	public double getTaxaRendimento() {
		return taxaRendimento;
	}
	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public Event getCurrentEvent() {
		return currentEvent;
	}

	public void setCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
	}
}
