package ProntoSocorro;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Atendimento {

    protected Fila fila;
    protected Medico medico;
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
    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }
    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public boolean realizaAtendimento(Paciente paciente, Medico medico) {
        adicionaAtendidos(paciente);
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
        if (listaAtendidos.isEmpty()) { 
        	return null;
        }
        return listaAtendidos.get(listaAtendidos.size() - 1);
    }
}
