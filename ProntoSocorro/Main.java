package ProntoSocorro;

public class Main {
	
	public static void main (String[] args) {
        
		Fila fila = new Fila();
		Atendimento atendimento = new Atendimento();
		Medico medico = new Medico();

		medico.iniciaMedico();
		fila.iniciaFila();
		
		atendimento.setMedicos(medico.getListMedico());
		atendimento.setFila(fila);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface(fila, medico).setVisible(true);
            }
        });
        
	}
	
}

