package ProntoSocorro;

import java.util.List;
import java.util.ArrayList;

public class HistoricoAtendimento {

	protected Atendimento atendimento;
	private List<Atendimento> atendimentosRealizados = new ArrayList<>();

	public Atendimento getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public List<Atendimento> getAtendimentosRealizados() {
		return atendimentosRealizados;
	}

	public boolean addAtendimentoRealizado(Atendimento atendimento) {
		atendimentosRealizados.add(atendimento);
		return true;
	}
	
	public List<String> getAtendimentosMedico(Medico medico) {
		List<String> atendimentosMedico = new ArrayList<>();
		
		for (int i = 0; i < atendimentosRealizados.size(); i++) {
	        if (medico == atendimentosRealizados.get(i).getMedico()) {
				StringBuilder relatorio = new StringBuilder();
		        relatorio.append("\nAtendimento\n");
		        relatorio.append("Medico: ").append(atendimento.getMedico()).append("\n");
		        relatorio.append("Paciente: ").append(atendimento.getPacienteAtendido()).append("\n");
		        relatorio.append("Horario do atendimento: ").append(atendimento.getHorarioAtendimento()).append("\n");
		        atendimentosMedico.add(relatorio.toString());
	        }
		}
		
		if (atendimentosMedico.size() > 0) {
			return atendimentosMedico;
		} else {
			return null;
		}
	}
	
}
