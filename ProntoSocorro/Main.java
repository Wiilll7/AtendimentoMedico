package ProntoSocorro;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main (String[] args) {
		
		Fila fila = new Fila();
		Atendimento atendimento = new Atendimento();
		Medico medico = new Medico();
		HistoricoAtendimento historico = new HistoricoAtendimento();
		LocalTime hora = LocalTime.now();
		String format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

		medico.iniciaMedico();
		fila.iniciaFila();
		
		int a = 219;
		hora = LocalTime.now();
		format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		Paciente p = new Paciente("Willian", "210.320.435-21", format);
		p.setClassificacao(a);
		fila.adicionarFila(p);
		
		a = 8;
		hora = LocalTime.now();
		format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		p = new Paciente("Willian", "254.673.234-75", format);
		p.setClassificacao(a);
		fila.adicionarFila(p);
		
		a = 1;
		hora = LocalTime.now();
		format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		p = new Paciente("Willian", "897.234.825-38", format);
		p.setClassificacao(a);
		fila.adicionarFila(p);
		
		a = 8;
		hora = LocalTime.now();
		format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		p = new Paciente("Willian", "184.145.765-49", format);
		p.setClassificacao(a);
		fila.adicionarFila(p);
		
		a = 6;
		hora = LocalTime.now();
		format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		p = new Paciente("Willian", "465.872.198-43", format);
		p.setClassificacao(a);
		fila.adicionarFila(p);
		
		a = 1;
		hora = LocalTime.now();
		format = hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		p = new Paciente("Willian", "865.123.541-53", format);
		p.setClassificacao(a);
		fila.adicionarFila(p);
		
		System.out.println(fila.getFila());
		System.out.println("=======================================");
		
		atendimento.setMedicos(medico.getListMedico());
		atendimento.setFila(fila);
		atendimento.realizaAtendimento(fila, medico.getMedico(0));
		historico.setAtendimento(atendimento);
		historico.adicionaAtendimentoRealizado(atendimento);
		
		atendimento.realizaAtendimento(fila, medico.getMedico(1));
		historico.setAtendimento(atendimento);
		historico.adicionaAtendimentoRealizado(atendimento);
		
		atendimento.realizaAtendimento(fila, medico.getMedico(0));
		historico.setAtendimento(atendimento);
		historico.adicionaAtendimentoRealizado(atendimento);
		
		atendimento.realizaAtendimento(fila, medico.getMedico(1));
		historico.setAtendimento(atendimento);
		historico.adicionaAtendimentoRealizado(atendimento);
		
		System.out.println(atendimento.getListaAtendidos());
		System.out.println("=======================================");
		System.out.println(fila.getFila());
		System.out.println("=======================================");
		System.out.println(medico.getListMedico());
		System.out.println("=======================================");
		System.out.println(historico.getAtendimentosMedico(0));
		System.out.println("=======================================");
		System.out.println(historico.getAtendimentosMedico(1));
		System.out.println("=======================================");
		if (historico.getAtendimentosMedico(2) == null) {
			System.out.println("Esse medico ainda nao atendeu nenhum paciente");
		} else {
			System.out.println(historico.getAtendimentosMedico(2));
		}
	}
}

