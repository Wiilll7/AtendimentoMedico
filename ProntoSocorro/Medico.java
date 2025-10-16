package ProntoSocorro;

public class Medico extends Pessoa {

	public Medico(String nome, String cpf) {
		super(nome, cpf);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
