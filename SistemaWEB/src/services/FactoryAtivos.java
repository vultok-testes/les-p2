package services;

import model.Ativo;

public class FactoryAtivos {
	public Ativo getAtivo(int tipo) {
		Ativo ativo = new Ativo();
		
		ativo.setTipo(tipo);
		
		switch (tipo) {
		case Ativo.MESA:
			setDadosMesa(ativo);
			break;
		case Ativo.CADEIRA:
			setDadosCadeira(ativo);
			break;
		default:
			setDadosComputador(ativo);
			break;
		}
		
		
		return ativo;
	}

	private Ativo setDadosComputador(Ativo ativo) {
		int tipo = ativo.getTipo();
		String nome = "";
		String descricao = "";
		double preco = 0D;

		switch(tipo) {
		case Ativo.PC_LESMA:
			preco = 1.55;
			nome = "PC malfeito";
			descricao = "Serve como um bom coletor de poeira";
			break;
		case Ativo.PC_CORREIOS:
			preco = 10.50;
			nome = "PC meia-boca";
			descricao = "... dá para usar (quando [se] ligar)";
			break;
		case Ativo.PC_PASTEL:
			preco = 20.45;
			nome = "PC comum";
			descricao = "Não é nenhum sonho de consumo, mas serve";
			break;
		case Ativo.PC_FOGUETE:
			preco = 4500; // P*TA MERDA QUE TROÇO CARO
			nome = "UM MOTHERF*CKING PC";
			descricao = "UM MOSTRO NO ASFALTO!! FAS QUAUQUER COISA: EDIÇÃO, RENDERIZAÇÃO, JOGOS, DESENHA, COZINHA, LIMPA, "
					+ "\nPASSA, RECOLHE O LIXO, FAZ CHURRASCO NOS FINAIS DE SEMANA, SABE PILOTAR CAMINHÃO "
					+ "(SIM, UM MOTHERF*CKING CAMINHHHHÃÃÃÃÃÃÃÃÃÃÃÃÃÃÃÃOOOOOOOO DE 32 RODAS),\nAUTOMATICAMENTE ESPANTA VENDEDORES "
					+ "DE PORTA-EM-PORTA, ENFIM, O VERDADEIRO COMPANHEIRO DE TODA VIDA. \nobs:custamuitocaro";
			break;

		}
		
		ativo.setValorCompra(preco);
		ativo.setNome(nome);
		ativo.setDescrição(descricao);

		return ativo;
	}

	private Ativo setDadosCadeira(Ativo ativo) {
		ativo.setNome("Cadeira de escritório");
		ativo.setDescrição("Faltam alguns parafusos...");
		ativo.setValorCompra(8.5);
		return ativo;
	}

	private Ativo setDadosMesa(Ativo ativo) {
		ativo.setNome("Mesa de escritótio");
		ativo.setDescrição("Alguns parafusos estão \"um pouco\" enferrujados... \n");
		ativo.setValorCompra(12.5);
		return ativo;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			Ativo a = new FactoryAtivos().getAtivo(i);
			System.out.println(a.getTipo() + " " + a.getNome() + " " + a.getDescrição() + " " + a.getValorCompra());
		}
	}
}
