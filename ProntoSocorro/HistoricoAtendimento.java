package ProntoSocorro;

import java.util.List;
import java.util.ArrayList;

public class HistoricoAtendimento {

	protected Atendimento atendimento;
	private List<Atendimento> atendimentosRealizados = new ArrayList<>();
	private List<String> historicoMedico1 = new ArrayList<>();
	private List<String> historicoMedico2 = new ArrayList<>();
	private List<String> historicoMedico3 = new ArrayList<>();

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
		addAtendimentoMedico(atendimento);
		return true;
	}
	
        public void addAtendimentoMedico(Atendimento atendimento) {

            StringBuilder relatorio = new StringBuilder();
            relatorio.append("\nAtendimento\n");
            relatorio.append("Medico: ").append(atendimento.getMedico()).append("\n");
            relatorio.append("Paciente: ").append(atendimento.getPacienteAtendido()).append("\n");
            relatorio.append("Horario do atendimento: ").append(atendimento.getHorarioAtendimento()).append("\n");

            Medico m = atendimento.getMedico();
            if (historicoMedico1.isEmpty() || historicoMedico1.get(0).contains(m.getNome())) {
                historicoMedico1.add(relatorio.toString());
            } else if (historicoMedico2.isEmpty() || historicoMedico2.get(0).contains(m.getNome())) {
                historicoMedico2.add(relatorio.toString());
            } else {
                historicoMedico3.add(relatorio.toString());
            }
        }
	
	public List<String> getAtendimentosMedico(int index) {
		if (index == 1) {
			return historicoMedico1;
		} else if (index == 2) {
			return historicoMedico2;
		} else if (index == 3) {
			return historicoMedico3;
		} else {
			return null;
		}
	}
	
}
