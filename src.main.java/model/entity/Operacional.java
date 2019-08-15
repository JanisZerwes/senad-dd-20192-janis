package model.entity;

public class Operacional extends Empregados {

	double salarioOperacional() {
		double salario = 0;
		salario = this.salBase() * 0.85;
		return salario;
	}

}
