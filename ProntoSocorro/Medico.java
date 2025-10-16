package ProntoSocorro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Medico extends Pessoa {

	private String crm;
	
	public Medico() {
		
	}
	
	public Medico(String nome, String cpf, String crm) {
		super(nome, cpf);
	}
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}

	private List<Medico> medicos = new ArrayList<Medico>();
	
	public boolean iniciaMedico() {
		String[] nomes = {"João", "Carlos", "Pedro", "Marcelo", "Ricardo", "Ana", "Juliana", "Mariana", "Fernanda", "Patrícia"};
		String[] sobrenomes = {"Silva", "Souza", "Oliveira", "Santos", "Lima", "Carvalho", "Almeida", "Ferreira", "Costa", "Rodrigues", "Martins", "Pereira", "Moretti", "Müller", "González"};
		Random random = new Random();
		
		for (int i = 0; i < 5; i++) {
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
			medicos.add(m);
		}
		
		return true;
	}
	
	public List<Medico> getListMedico() {
		return medicos;
	}

	public Medico getMedico(int index) {
		return medicos.get(index);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [crm=");
		builder.append(crm);
		builder.append(", medicos=");
		builder.append(medicos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}

}
