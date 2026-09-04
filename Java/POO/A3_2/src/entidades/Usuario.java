package entidades;

public class Usuario {
	//Atributos
	private String nome;
	private String cpf;
	private Integer idade;
	private String id;
	
	public Usuario(String nome, Integer idade, String id) {
		this.nome = nome;
		this.idade = idade;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
