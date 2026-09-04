package entidades;

public class Diretor extends Usuario {
	private String telefone;

	// metodos especiais
	public Diretor(String nome, Integer idade, String id, String telefone) {
		super(nome, idade, id);
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Diretor [Telefone=" + getTelefone() + ", Nome=" + getNome() + ", Idade=" + getIdade() + ", ID=" + getId()
				+ "]";
	}
	
	public String contato() {
		return "Contato do Diretor: "+getNome()+", "+getTelefone();
	}

	// verificador de Id de Diretor
	public boolean verificadorIdDiretor(String id) {
		return getId().equalsIgnoreCase(id);
	}
}
