package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Turma implements Comparable<Turma> { 
	private String nomeTurma;
	private String nomeProfessor;
	private String diaHorario;
	private String id;

	private ArrayList<NotaAluno> alunosTurma;
	
	private static List<Turma> turmas = new ArrayList<>();

	public Turma(String nomeTurma, String id,String nomeProfessor, String diaHorario) {
		this.nomeTurma = nomeTurma;
		this.id = id;
		this.nomeProfessor = nomeProfessor;
		this.diaHorario = diaHorario;
		this.alunosTurma = new ArrayList<>();
	}

	
	//metodos especiais
	public String getNomeTurma() {
		return nomeTurma;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}


	public String getNomeProfessor() {
		return nomeProfessor;
	}



	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}



	public String getDiaHorario() {
		return diaHorario;
	}



	public void setDiaHorario(String diaHorario) {
		this.diaHorario = diaHorario;
	}



	public ArrayList<NotaAluno> getAlunosTurma() {
		return alunosTurma;
	}

	public void setAlunosTurma(ArrayList<NotaAluno> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}
	
	public static void setTurmas(List<Turma> turmas) {
		Turma.turmas = turmas;
	}

	
	public static List<Turma> getTurmas() {
        return turmas;
    }

	@Override
	public String toString() {
		return "Turma [Nome = " + nomeTurma + ", ID = " + id + ", Professor = " + nomeProfessor + 
				", Horário = " + diaHorario + "]";
	}
	public int compareTo(Turma outra) {
	    return this.nomeTurma.compareToIgnoreCase(outra.nomeTurma);
	}

	//Adicionar aluno
	public void adicionarAluno(Aluno aluno) {
		NotaAluno notaAluno = new NotaAluno(aluno.getNome(), aluno.getId(), 0.0);
		alunosTurma.add(notaAluno);
		Collections.sort(alunosTurma);
		
	}
	
	//Criar turma
	public static String criarTurma(String nomeTurma, String nomeProfessor, String diaHorario) {
		
		String idGerado = GeradorID.gerarIdTurma();
		
		Turma turma = new Turma(nomeTurma, idGerado, nomeProfessor, diaHorario);
		turma.setId(idGerado);
		turmas.add(turma);
		Collections.sort(turmas); 
				
		return idGerado;
	}
	
	//Buscar turma por ID
	public static Turma buscarTurmaPorId(String id) {
		for (Turma turma : turmas) {
			if (turma.getId().equalsIgnoreCase(id)) {
				return turma;
			}
		}
		return null;
	}
	
	//Listar alunos turma
	public void listarAlunosDaTurma() {
		System.out.println("\n=== Alunos da Turma " + nomeTurma + " (" + id + ") ===");
		if (alunosTurma.isEmpty()) {
			System.out.println("Nenhum aluno matriculado nessa turma");
			return;
		}
		for (NotaAluno na : alunosTurma) {
			System.out.println("Aluno: " + na.getNome() + ", ID: " + na.getId() + ", Nota: " + na.getNota() + ", Aprovado: " + na.getAprovado());
		}
	}
	
	//buscarNotaAluno
	public NotaAluno buscarNotaAlunoPorId(String idAluno) {
		for (NotaAluno na : alunosTurma) {
			if (na.getId().equalsIgnoreCase(idAluno)) {
				return na;
			}
		}
		return null;
	}
	
	//Remover aluno da turma pelo ID do aluno
	public boolean removerAlunoDaTurmaPorId(String idAluno) {
		for (int i = 0 ; i < alunosTurma.size(); i++) {
			NotaAluno na = alunosTurma.get(i);
			if (na.getId().equalsIgnoreCase(idAluno)) {
				alunosTurma.remove(i);
				return true;
			}
		}
		return false;
	}
	
}

