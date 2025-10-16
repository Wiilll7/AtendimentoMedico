package ProntoSocorro;

public class Paciente extends Pessoa {
	
	private String classificacao;
	private int num;
	
	public Paciente(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public boolean classificar(int num) {
		
		if (num < 2) {
			setClassificacao("Azul");
		} else if (num < 6){
			setClassificacao("Verde");
		} else if (num < 10) {
			setClassificacao("Amarelo");
		} else {
			setClassificacao("Vermelho");
		}
		
		return true;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente ");
		builder.append(super.getNome());
		builder.append(", CPF:");
		builder.append(super.getCpf());
		builder.append("; Classificação:");
		builder.append(classificacao);
		builder.append("\n");
		return builder.toString();
	}

}
