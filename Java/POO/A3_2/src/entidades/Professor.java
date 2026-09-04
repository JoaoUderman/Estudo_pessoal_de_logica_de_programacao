package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Professor extends Usuario implements Comparable<Professor> {

	private static List<Professor> professores = new ArrayList<>();
	private static String idProfessorLogado;

	public Professor(String nome, Integer idade, String id) {
		super(nome, idade, id);

	}

	@Override
	public String toString() {
		return "Professor [Nome = " + getNome() + ", Idade=" + getIdade() + ", Id=" + getId() + "]";
	}
	public int compareTo(Professor outro) {
	    return this.getNome().compareToIgnoreCase(outro.getNome());
	}

	// Cadastrar professor
	public static String cadastrarProfessor(String nome, int idade, String cpf) {

		String idGerado = GeradorID.gerarIdProfessor(cpf);

		Professor professor = new Professor(nome, idade, idGerado);
		professor.setCpf(cpf);

		professores.add(professor);
		Collections.sort(professores);

		return idGerado;
	}

	// Lisatar professor
	public static List<Professor> getProfessores() {
		return professores;
	}

	// Buscar professor por nome
	public static Professor buscarProfessorNome(String nome) {
		Professor professorEncontrado = null;

		for (Professor professor : professores) {
			if (professor.getNome().equalsIgnoreCase(nome)) {
				professorEncontrado = professor;
				break;
			}
		}
		return professorEncontrado;
	}

	// Buscar professor por ID
	public static Professor buscarProfessorID(String id) {
		Professor professorEncontrado = null;

		for (Professor professor : professores) {
			if (professor.getId().equalsIgnoreCase(id)) {
				professorEncontrado = professor;
				break;
			}
		}
		return professorEncontrado;
	}
	
	// Verificar ID do professor
	public static boolean verificadorIdProfessor(String id) {
		Boolean encontrado = false;
		for (Professor professor : professores) {
			if (professor.getId().equalsIgnoreCase(id )) {
				encontrado = true;
				idProfessorLogado(id);
			}
		}
		return encontrado;
	}
	
		//Guardar ID
		public static void idProfessorLogado(String idRecebido) {
			idProfessorLogado = idRecebido;
		}
		//Pegar Id
		public static String getIdLogado() {
	        return idProfessorLogado;
	    }

	// excluir professor por id
	public static boolean excluirProfessor(Professor professor) {
		return professores.remove(professor);
	}
}
