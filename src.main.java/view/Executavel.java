package view;

import model.entity.Diretor;
import model.entity.Gerente;
import model.entity.Operacional;

public class Executavel {

	public static void main(String[] args) {
		// private int id;
		// private String nome;
		// private String cpf;
		// private String sexo;
		// private Integer idade;
		// private double salBruto;

		Operacional op1 = new Operacional();
		op1 = metodoOperacional();
		System.out.println(op1);

		Diretor dir1 = new Diretor();
		dir1 = metodoDiretor();
		System.out.println(dir1);

		Gerente ger1 = new Gerente();
		ger1 = metodoGerente();
		System.out.println(ger1);

		Gerente ger2 = new Gerente();
		ger2 = metodoGerenciaSubordinado();
	}

	private static Gerente metodoGerenciaSubordinado() {
		Gerente novoGerenteSubordinado = new novoGerenteSubordinado();
		novoGerenteSubordinado.ge
		return null;
	}

	private static Gerente metodoGerente() {
		Gerente novoGerente = new Gerente();
		novoGerente.setNome("Maick");
		novoGerente.setCpf("325.665.982-44");
		novoGerente.setSexo("M");
		novoGerente.setIdade(32);
		novoGerente.setSalBruto(3750);
		return novoGerente;
	}

	private static Diretor metodoDiretor() {
		Diretor novoDiretor = new Diretor();
		novoDiretor.setNome("Janis");
		novoDiretor.setCpf("080.042.399-27");
		novoDiretor.setSexo("F");
		novoDiretor.setIdade(27);
		novoDiretor.setSalBruto(3800);
		return novoDiretor;
	}

	private static Operacional metodoOperacional() {
		Operacional novoOperacional = new Operacional();

		novoOperacional.setNome("Jorge");
		novoOperacional.setCpf("254.696.874-55");
		novoOperacional.setSexo("M");
		novoOperacional.setIdade(27);
		novoOperacional.setSalBruto(2000);
		return novoOperacional;

	}

}
