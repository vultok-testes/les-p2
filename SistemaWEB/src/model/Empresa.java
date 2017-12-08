package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Empresa {
	/**
	 * Constante criada para evitar <em>'typos'</em> quanto aos atributos das páginas 
	 * com relação ao <strong> nome </strong> da empresa.
	 */
	public static final String COMPANY_NAME = "cname";
	public static final String COMPANY_DAYS = "dias";
	
	private long id;
	private String nome;
	/**
	 * Quanta bufunfa a empresa tem, sendo considerado seus gastos com ativos,
	 * funcionários e eventuais 'acontecimentos', bem como rendimentos.
	 */
	private double saldo;
	private List<Funcionario> funcionarios;
	private int[] qtdAtivos;
	private long diasPassados;
	
	public void nextDay() {
		double saldoAtual = saldo;
		double lucroDiario;
		double gastoDiario;
		
		lucroDiario = calculateDailyProfit();
		gastoDiario = calculateDailyExpense();
		
		saldoAtual = saldoAtual + (lucroDiario - gastoDiario);
		saldoAtual = round(saldoAtual, 3);
		//System.out.println(getSaldo() + ' ' + saldoAtual);
		setSaldo(saldoAtual);
		diasPassados++;
		System.out.println("próximo dia da empresa: " + diasPassados);
	}
	
	public double calculateDailyExpense() {
		double expense = 0;
		
		for(Funcionario f : funcionarios) {
			expense = expense + f.getSalario();
		}
		
		expense = round(expense, 3);
		return expense;
	}
	
	public double calculateDailyProfit() {
		double profit = 0;
		
		for(Funcionario f : funcionarios) {
			profit = profit + ( f.getRendimentoMaximo() * f.getTaxaRendimento() );
		}
		
		profit = round(profit, 3);
		return profit;
	}
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public int getQtdTipoAtivo(int tipo) {
		int qtd = 0;
		
		switch(tipo) {
		case Ativo.CADEIRA: 
				qtd = qtdAtivos[Ativo.CADEIRA];
			break;
			
		case Ativo.MESA:
			qtd = qtdAtivos[Ativo.MESA];
			break;
			
		case Ativo.PC_LESMA:
		case Ativo.PC_CORREIOS:
		case Ativo.PC_PASTEL:
		case Ativo.PC_FOGUETE:
			qtd = qtd + qtdAtivos[Ativo.PC_LESMA];
			qtd = qtd + qtdAtivos[Ativo.PC_CORREIOS];
			qtd = qtd + qtdAtivos[Ativo.PC_PASTEL];
			qtd = qtd + qtdAtivos[Ativo.PC_FOGUETE];
		}
		
		return qtd;
	}
		
	public int adicionarFuncionario(Funcionario funcionario) {
		Funcionario temp = doesItAlreadyExists(funcionario);

		if (!(temp == null)) {
			return -1;
		}

		funcionarios.add(funcionario);

		return 0;
	}

	public int removerFuncionario(Funcionario funcionario) {
		funcionario = doesItAlreadyExists(funcionario);

		if (funcionario == null) {
			return -1;
		}

		funcionarios.remove(funcionario);

		return 0;
	}

	private Funcionario doesItAlreadyExists(Funcionario funcionario) {
		for (Funcionario f : funcionarios) {
			if (f.getId() == funcionario.getId()) {
				return f;
			}
		}

		return null;
	}

	// Getters e Setters
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public long getDiasPassados() {
		return diasPassados;
	}

	public void setDiasPassados(long diasPassados) {
		this.diasPassados = diasPassados;
	}

	public int[] getQtdAtivos() {
		return qtdAtivos;
	}

	public void setQtdAtivos(int[] qtdAtivos) {
		this.qtdAtivos = qtdAtivos;
	}
}
