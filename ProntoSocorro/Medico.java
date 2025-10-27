package ProntoSocorro;

public class Medico extends Pessoa {

	private String crm;
	
	public Medico() {
		
	}
	
	public Medico(String nome, String cpf, String crm) {
		super(nome, cpf);
		setCrm(crm);
	}
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		if (crm.length() > 8)
		this.crm = crm;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getNome());
		builder.append(", CRM: ");
		builder.append(crm);
		builder.append(", CPF: ");
		builder.append(super.getCpf());
		return builder.toString();
	}

}
