package model.entity;

public class Empregados {
	@Override
	public String toString() {
		return "Empregados [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", idade=" + idade
				+ ", salBruto=" + salBruto + "]";
	}

	private int id;
	private String nome;
	private String cpf;
	private String sexo;
	private Integer idade;
	private double salBruto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public double getSalBruto() {
		return salBruto;
	}

	public void setSalBruto(double salBruto) {
		this.salBruto = salBruto;
	}

	public double descontoImposto() {
		double descontoImposto = 0;
		double salbruto = this.getSalBruto();
		if (salbruto < 1800) {
			descontoImposto = 0;
		} else if (salbruto >= 1800 || salbruto <= 3000) {
			descontoImposto = salbruto * 0.1;

		} else {
			descontoImposto = salbruto * 0.15;

		}
		return descontoImposto;
	}

	public double contribuicaoPrevidenciaria() {
		double contribuicao = 0;
		if (this.idade < 45) {
			contribuicao = this.getSalBruto() * 0.12;
		} else {
			contribuicao = this.getSalBruto() * 0.08;
		}

		return contribuicao;
	}

	public double salBase() {
		double salarioBase = this.getSalBruto() - this.contribuicaoPrevidenciaria() - this.descontoImposto();
		return salarioBase;
	}
}
