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
		
		atendimento.setMedicos(medico.getListMedico());
		atendimento.setFila(fila);

                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Interface(fila, medico).setVisible(true);
                    }
                });
                
        
	}
	
}

