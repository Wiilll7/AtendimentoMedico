package ProntoSocorro;

public class Paciente extends Pessoa {
	
	private String classificacao;
	private String horarioChegada;
	
	public Paciente() {
		
	}
	
	public Paciente(String nome, String cpf, String horarioChegada) {
		super(nome, cpf);
		setHorarioChegada(horarioChegada);
	}
	
	public String getHorarioChegada() {
		return horarioChegada;
	}
	public void setHorarioChegada(String horarioChegada) {
		if (horarioChegada.length() > 6)
		this.horarioChegada = horarioChegada;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int num) {
		if (num < 2) {
			classificacao = "Azul";
		} else if (num < 6){
			classificacao = "Verde";
		} else if (num < 10) {
			classificacao = "Amarelo";
		} else {
			classificacao = "Vermelho";
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getNome());
		builder.append(", CPF: ");
		builder.append(super.getCpf());
		builder.append(", Classificação: ");
		builder.append(classificacao);
		builder.append(", Horario de chegada: ");
		builder.append(horarioChegada+"\n");
		return builder.toString();
	}


}
