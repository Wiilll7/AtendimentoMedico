package ProntoSocorro;

public class Pessoa {

	private String nome;
	private String cpf;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome.length() > 3)
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if (cpf.length() > 10)
		this.cpf = cpf;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append("]");
		return builder.toString();
	}
}
