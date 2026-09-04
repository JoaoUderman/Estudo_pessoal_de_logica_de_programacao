package entidades;

public class NotaAluno implements Comparable<NotaAluno> {

	//Atributos
	private String nome;
	private String id;
	private double nota;
	private boolean aprovado;
	
	//Metodos especiais
	public boolean getAprovado() {
		return aprovado;
	}
	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getNome() {
		return nome;
	}
	public NotaAluno(String nome, String id, double nota) {
		this.nome = nome;
		this.id = id;
		this.nota = nota;
		this.aprovado = nota >= 7;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
		this.aprovado = nota >= 7;
	}
	
	@Override
	public int compareTo(NotaAluno outro) {
	    return this.nome.compareToIgnoreCase(outro.nome);
	}
	//Metodos
}
