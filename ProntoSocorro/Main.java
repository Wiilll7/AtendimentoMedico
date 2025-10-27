package ProntoSocorro;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {
	
	public static List<Medico> iniciaMedico() {
		List<Medico> listaMedicos = new ArrayList<>();
		
		String[] nomes = {"João", "Carlos", "Pedro", "Marcelo", "Ricardo", "Ana", "Juliana", "Mariana", "Fernanda", "Patrícia"};
		String[] sobrenomes = {"Silva", "Souza", "Oliveira", "Santos", "Lima", "Carvalho", "Almeida", "Ferreira", "Costa", "Rodrigues", "Martins", "Pereira", "Moretti", "Müller", "González"};
		Random random = new Random();
		
		for (int i = 0; i < 3; i++) {
			StringBuilder cpf = new StringBuilder();
			StringBuilder crm = new StringBuilder();
			String nome = nomes[random.nextInt(0, 10)];
			String sobrenome = sobrenomes[random.nextInt(0, 10)];
			
			for (int j = 0; j < 11; j++) {
				cpf.append(random.nextInt(0, 10));
				if (cpf.length() == 3 || cpf.length() == 7) {
					cpf.append(".");
				} else if (cpf.length() == 11) {
					cpf.append("-");
				}
			}
			
			for (int j = 0; j < 6; j ++) {
				crm.append(random.nextInt(0, 9));
			}
			crm.append("/SC");
			
			Medico m = new Medico("Dr. "+nome+" "+sobrenome, cpf.toString(), crm.toString());
			listaMedicos.add(m);
		}
		
		return listaMedicos;
	}
	
	public static void main (String[] args) {
        
		Fila fila = new Fila();
		List<Medico> listaMedicos = iniciaMedico();

		fila.iniciaFila();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface(fila, listaMedicos).setVisible(true);
            }
        });
        
	}
	
}

