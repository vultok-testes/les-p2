package model;

/**
 * Classe contém os dados dos bens materiais da empresa, 
 * como cadeiras, computadores e mesas.
 * @author elton
 *
 */
public class Ativo {
	private int tipo;
	private String nome;
	private String descrição;
	private double valorCompra;
	
	// Constantes
	public static final int MESA = 0; //yeahh, f*ck la politze
	public static final int CADEIRA = 1;
	public static final int PC_LESMA = 2;
	public static final int PC_CORREIOS = 3; 	//Para fins legais, me chamo Correios da Silva (e sou meio lento) 
	public static final int PC_PASTEL = 4; 	//Pc comum, sem novidades
	public static final int PC_FOGUETE = 5;	//Esse sim, o bichano até voa
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
}
