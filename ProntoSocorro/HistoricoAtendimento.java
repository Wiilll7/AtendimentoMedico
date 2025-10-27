package ProntoSocorro;

import java.util.List;
import java.util.ArrayList;

public class HistoricoAtendimento {

	protected Atendimento atendimento;
	private List<Atendimento> atendimentosRealizados = new ArrayList<>();
	private List<List<String>> atendimentosMedico = new ArrayList<>();
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
                if (atendimentosMedico.size() > 0) {
                    atendimentosMedico.set(0, historicoMedico1);
                } else {
                    atendimentosMedico.add(historicoMedico1);
                }
            } else if (historicoMedico2.isEmpty() || historicoMedico2.get(0).contains(m.getNome())) {
                historicoMedico2.add(relatorio.toString());
                if (atendimentosMedico.size() > 1) {
                    atendimentosMedico.set(1, historicoMedico2);
                } else {
                    atendimentosMedico.add(historicoMedico2);
                }
            } else {
                historicoMedico3.add(relatorio.toString());
                if (atendimentosMedico.size() > 2) {
                    atendimentosMedico.set(2, historicoMedico3);
                } else {
                    atendimentosMedico.add(historicoMedico3);
                }
            }
        }
	
	public List<String> getAtendimentosMedico(int index) {
		if (atendimentosMedico.size() > index) {
			return atendimentosMedico.get(index);
		} else {
			return null;
		}
	}
	
}
