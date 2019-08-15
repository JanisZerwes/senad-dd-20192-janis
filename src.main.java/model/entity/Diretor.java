package model.entity;

import java.util.ArrayList;

public class Diretor extends Empregados {
	private double comissao;
	private String nomeDiretoria;
	private String sigla;

	private ArrayList<Diretor> diretor;

	public ArrayList<Diretor> getDiretor() {
		return diretor;
	}

	public void setDiretor(ArrayList<Diretor> diretor) {
		this.diretor = diretor;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public String getNomeDiretoria() {
		return nomeDiretoria;
	}

	public void setNomeDiretoria(String nomeDiretoria) {
		this.nomeDiretoria = nomeDiretoria;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public double salarioDiretor() {
		double salario = 0;

		salario = 3 * this.getSalBruto() + this.comissao;

		return salario;
	}

}
