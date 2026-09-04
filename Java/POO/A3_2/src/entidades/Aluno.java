package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Aluno extends Usuario implements Comparable<Aluno> {
	
	private static List<Aluno> alunos = new ArrayList<>();
	private static String idAlunoLogado;
	
	//metodos especiais
	private String semestre;	
	private boolean aprovação;

	public boolean isAprovação() {
		return aprovação;
	}

	public void setAprovação(boolean aprovação) {
		this.aprovação = aprovação;
	}


	public Aluno(String nome, Integer idade, String id, String semestre) {
		super(nome, idade, id);
		this.semestre = semestre;
		
	}
	
	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


	@Override
	public String toString() {
		return "Aluno [Nome = " + getNome() + ", Semestre =  " + getSemestre() +", Idade=" + getIdade() + ", Id="
				+ getId() +  "]";
	}
	public int compareTo(Aluno outro) {
	    return this.getNome().compareToIgnoreCase(outro.getNome());
	}
	
	//Cadastrar aluno
		public static String cadastrarAlunos(String nome, int idade, String semestre, String cpf) {
						
			String idGerado = GeradorID.gerarIdAluno(cpf);
			
			Aluno aluno = new Aluno(nome, idade, idGerado, semestre);
			aluno.setCpf(cpf);
			
			alunos.add(aluno);
			Collections.sort(alunos);
			
			return idGerado;
		}
	//Listar Alunos
		public static List<Aluno> getAlunos() {
		    return alunos;
		}
	
	//Excluir aluno
		public static boolean excluirAluno(Aluno aluno) {
			return alunos.remove(aluno);
		}
		
	//Buscar por ID
		public static Aluno buscarAlunoID(String id) {
			Aluno alunoEncontrado = null;
			
			for (Aluno aluno : alunos) {
				if (aluno.getId().equalsIgnoreCase(id)) {
					alunoEncontrado = aluno;
					break;
				}
			}
			return alunoEncontrado;
		}
		
	//Verificador do ID do aluno
		public static boolean verificadorIdAluno(String id) {
			Boolean encontrado = false;
			for (Aluno aluno : alunos) {
				if (aluno.getId().equalsIgnoreCase(id)) {
					encontrado = true;
					idAlunoLogado(id);
				}
			}
			return encontrado;
		}
			//Guardar ID
			public static void idAlunoLogado(String idRecebido) {
				idAlunoLogado = idRecebido;
			}
			//Pegar Id
			public static String getIdAlunoLogado() {
		        return idAlunoLogado;
		    }
		
	//Buscar por Nome
		public static Aluno buscarAlunoNome(String nome) {
			Aluno alunoEncontrado = null;
			
			for (Aluno aluno: alunos) {
				if (aluno.getNome().equalsIgnoreCase(nome)) {
					alunoEncontrado = aluno;
					break;
				}
			}
			return alunoEncontrado;
		}
}