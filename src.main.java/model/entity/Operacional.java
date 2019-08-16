package model.entity;

public class Operacional extends Empregados {

	private int idGerente;

	public int getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}

	double salarioOperacional() {
		double salario = 0;
		salario = this.salBase() * 0.85;
		return salario;
	}

}
