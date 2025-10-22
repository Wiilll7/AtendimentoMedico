package ProntoSocorro;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Atendimento {

	protected Fila fila;
	protected Medico medico;
	protected List<Medico> medicos;
	private List<Paciente> listaAtendidos = new ArrayList<>();
	private String horarioAtendimento;
	
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Medico getMedicos(int index) {
		return medicos.get(index);
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}
	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	
	public boolean realizaAtendimento(Fila fila, Medico medico) {
		adicionaAtendidos(fila.removeFila());
		setMedico(medico);
		LocalTime hora = LocalTime.now();
		String format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		setHorarioAtendimento(format);
		return true;
	}
	
	public boolean adicionaAtendidos(Paciente paciente) {
		listaAtendidos.add(paciente);
		return true;
	}
	
	public List<Paciente> getListaAtendidos() {
		return listaAtendidos;
	}
	
	public Paciente getPacienteAtendido() {
		return listaAtendidos.getLast();
	}
	
}
