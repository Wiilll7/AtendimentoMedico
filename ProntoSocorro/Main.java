package ProntoSocorro;

public class Main {
	
	public static void main (String[]args) {
		
		Fila fila = new Fila();
		Atendimento atendimento = new Atendimento();
		Medico medico = new Medico();
		
		medico.iniciaMedico();
		fila.iniciaFila();
		
		int a = 219;
		Paciente p = new Paciente("Willian", "210.320.435-21");
		p.classificar(a);
		fila.adicionarFila(p);
		
		a = 8;
		p = new Paciente("Willian", "254.673.234-75");
		p.classificar(a);
		fila.adicionarFila(p);
		
		a = 1;
		p = new Paciente("Willian", "897.234.825-38");
		p.classificar(a);
		fila.adicionarFila(p);
		
		a = 8;
		p = new Paciente("Willian", "184.145.765-49");
		p.classificar(a);
		fila.adicionarFila(p);
		
		a = 6;
		p = new Paciente("Willian", "465.872.198-43");
		p.classificar(a);
		fila.adicionarFila(p);
		
		a = 1;
		p = new Paciente("Willian", "865.123.541-53");
		p.classificar(a);
		fila.adicionarFila(p);
		
		System.out.println(fila.getFila());
		System.out.println("=======================================");
		
		atendimento.realizaAtendimento(fila.getFirst());
		
		System.out.println(atendimento.pacientes.getAtendidos());
		System.out.println("=======================================");
		System.out.println(fila.getFila());
		System.out.println("=======================================");
		
	}

}
