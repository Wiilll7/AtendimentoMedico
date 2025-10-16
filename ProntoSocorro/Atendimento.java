package ProntoSocorro;

public class Atendimento {
	
	Fila fila = new Fila();
	Paciente pacientes = new Paciente();
	
	public boolean realizaAtendimento(Paciente paciente) {
		pacientes.adicionaAtendidos(paciente);
		return true;
	}
	
}
