package events;

import model.Funcionario;

public class Event {
	private int type;
	private String desc;
	private double fator;
	private int atributoAfetado;
	
	/** <ul><li>
	 * Constante usada para definir um evento (<code>Event</code>) do <strong> tipo  
	 * usual, banal, comum, trivial </strong>.
	 * </li><li>
	 * Possui uma chance de <strong>74%</strong> de acontecer, ou seja, em teoria, a cada 100, 74 serão deste tipo.
	 * </li></ul>
	 * <blockquote><i>Porque as pessoas civilizadas começam a contar a partir do 0.</i></blockquote>.
	 */
	public static final int COMUM = 0; 
	public static final String[] COMUM_DESC = 
		{"pegou uma Gripe", "atrasou-se por conta do Metrô", "ficou preso em um engarrafamento", 
		 "atrasou-se por conta da chuva"};
	public static final double[] COMUM_FATOR = {-0.05D, -0.08D, -0.1D, -0.1D};
	public static final int COMUM_ATRIB = Funcionario.TAXA_RENDIMENTO;
	
	/** <ul><li>
	 * Constante usada para definir um evento (<code>Event</code>) do <strong> tipo  incomum, 
	 * mas que não é muito fora da realidade. </strong>
	 * </li><li>
	 * Possui uma chance de <strong>15%</strong> de acontecer, ou seja, em teoria, a cada 100, <br>
	 * 15 serão deste tipo.
	 * </li></ul>
	 */ 
	public static final int INCOMUM = 1;
	public static final String[] INCOMUM_DESC = 
		{"casou-se", "foi a um casamento", "ficou doente", "acordou atrasado"};
	public static final double[] INCOMUM_FATOR = {+0.5D, -0.3D, -0.3D, -0.2D};
	public static final int INCOMUM_ATRIB = Funcionario.TAXA_RENDIMENTO;
	
	
	/** <ul><li>
	 * Constante usada para definir um evento (<code>Event</code>) do <strong> tipo  incomum, 
	 * que é totalmente fora da realidade. </strong>
	 * </li><li>
	 * Possui uma chance de <strong>5%</strong> de acontecer, ou seja, em teoria, a cada 100, 5 serão deste tipo.
	 * </li></ul>
	 */
	public static final int WTF = 2;
	public static final String[] WTF_DESC =
		{"foi atacado por ursos", "comprou um jogo muito irado e vicou viciado", "virou hipster",//3
		 "está fugindo de agiotas", "descobriu que quer se tornar artista circense", "viajou para o Acre",//6
		 "está ajudando amigos próximos a \"eliminar pontas soltas\"", "foi em uma missão com seus novos amigos, os guaxinins-ninja",//8
		 "comeu torta de procedência suspeita (que não se lembra o sabor)", "está comemorando algum feriado da Papua-Nova Guiné"};//10
	public static final double[] WTF_FATOR = {-0.8D, -0.4D, -1D, -0.7D, -0.6D, -0.8D, -0.1D, +0.25D, -0.11D, +0.12D};
	public static final int WTF_ATRIB = Funcionario.TAXA_RENDIMENTO;
	
	
	/** <ul><li>
	 * Constante usada para definir um evento (<code>Event</code>) do <strong> tipo  muito raro, 
	 * podendo ou não ser algo surreal. </strong>
	 * </li><li>
	 * Possui uma chance de <strong>5%</strong> de acontecer, ou seja, em teoria, a cada 100, 5 serão deste tipo.
	 * </li></ul>
	 */
	public static final int RARO = 3;
	public static final String[] RARO_DESC =
		{"informa que seu cachorro faleceu", "fez uma cirurgia", "feriu-se ao ser atacado por um tubarão"};
	public static final double[] RARO_FATOR = {-0.9D, -0.4D, -1D};
	public static final int RARO_ATRIB = Funcionario.TAXA_RENDIMENTO;
	
	/** <ul><li>
	 * Constante usada para definir um evento (<code>Event</code>) do <strong> tipo  muito raro, 
	 * podendo ou não ser algo surreal. </strong>
	 * </li></li>
	 * Possui uma chance de <strong>1%</strong> de acontecer, ou seja, em teoria, a cada 100, 1 será deste tipo.
	 * </li></ul>
	 */
	public static final int ULTRA_RARO = 4;
	public static final String[] ULTRA_RARO_DESC = 
		{"comprou um bote salva-vidas e planeja sair mais cedo para testá-lo", 
		 "comprou um relógio no site Acoláexpress, mas recebeu uma geladeira", "foi atingido por um raio",
		 "comprou uma bicicleta"};
	public static final double[] ULTRA_RARO_FATOR = {+0.1D, +0.15D, -1D, +0.18D};
	public static final int ULTRA_RARO_ATRIB = Funcionario.TAXA_RENDIMENTO;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getFator() {
		return fator;
	}
	public void setFator(double fator) {
		this.fator = fator;
	}
	public int getAtributoAfetado() {
		return atributoAfetado;
	}
	public void setAtributoAfetado(int atributoAfetado) {
		this.atributoAfetado = atributoAfetado;
	}
	
	public String toJson() {
		String json = "{\"type\": \"" + type + "\", \"desc\": \"" + desc + "\", \"fator\": \"" 
				+ fator+ "\", \"attrib\": \"" + atributoAfetado + "\"}";
				
		return json;
	}
}
