package cap6;

import java.util.Calendar;

public class Cliente {
	private String nome, cpf;
	private Calendar nasc;

	public String getNome() {
		return nome;
	}

	public Cliente(String nome, String cpf, String nasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		//this.nasc = Calendar. new Gregnasc;
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

	public Calendar getNasc() {
		return nasc;
	}

	public void setNasc(Calendar nasc) {
		this.nasc = nasc;
	}
}
