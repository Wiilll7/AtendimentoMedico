package ProntoSocorro;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Fila {

	private List<Paciente> fila = new ArrayList<Paciente>();
	
	public boolean iniciaFila() {
		String[] nomes = {"Gabriel", "Rafael", "Lucas", "Thiago", "João", "Mariana", "Ana", "Beatriz", "Laura", "Camila"};
		String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Lima", "Pereira", "Costa", "Rodrigues", "Almeida", "Carvalho"};
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) {
			int clas = random.nextInt(1, 12);
			String cpf = "";
			String nome = nomes[random.nextInt(0, 10)];
			String sobrenome = sobrenomes[random.nextInt(0, 10)];
			
			for (int j = 0; j < 11; j++) {
				cpf += random.nextInt(0, 10);
				if (cpf.length() == 3 || cpf.length() == 7) {
					cpf += ".";
				} else if (cpf.length() == 11) {
					cpf += "-";
				}
			}
			
			Paciente p = new Paciente(nome+" "+sobrenome, cpf);
			p.classificar(clas);
			adicionarFila(p);
		}
		
		return true;
	}
	
	public boolean adicionarFila(Paciente paciente) {
		int pos = 0;
		
		if (paciente.getClassificacao().equals("Vermelho")) {
			while (pos < fila.size() && fila.get(pos).getClassificacao().equals("Vermelho")) {
				pos++;
			}
			fila.add(pos, paciente);
		} else if (paciente.getClassificacao().equals("Amarelo")) {
			Set<String> cores = new HashSet<>(Arrays.asList("Vermelho", "Amarelo"));
			while (pos < fila.size() && cores.contains(fila.get(pos).getClassificacao())) {
				pos++;
			}
			fila.add(pos, paciente);
		} else if (paciente.getClassificacao().equals("Verde")) {
			Set<String> cores = new HashSet<>(Arrays.asList("Vermelho", "Amarelo", "Verde"));
			while (pos < fila.size() && cores.contains(fila.get(pos).getClassificacao())){
				pos++;
			}
			fila.add(pos, paciente);
		} else {
			fila.addLast(paciente);
		}
		
		return true;
	}
	
	public List<Paciente> getFila() {
		return fila;
	}
	
}
