package model.entity;

import java.util.ArrayList;

public class Gerente extends Empregados {
	private double comissao;
	private int idDiretoria;

	private ArrayList<Operacional> operacionais;

	public double getComissao() {
		return comissao;
	}

	public int getIdDiretoria() {
		return idDiretoria;
	}

	public void setIdDiretoria(int idDiretoria) {
		this.idDiretoria = idDiretoria;
	}

	public ArrayList<Operacional> getOperacionais() {
		return operacionais;
	}

	public void setOperacionais(ArrayList<Operacional> operacionais) {
		this.operacionais = operacionais;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public double salarioGerente() {
		double salario = 0;

		salario = this.salBase() * 0.90 + this.comissao;
		return salario;
	}
}
