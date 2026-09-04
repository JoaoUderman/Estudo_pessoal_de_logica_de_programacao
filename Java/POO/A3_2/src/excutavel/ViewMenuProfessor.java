package excutavel;
import java.util.List;
import java.util.Scanner;


import entidades.Professor;
import entidades.Turma;
import entidades.NotaAluno;
import entidades.Aluno;


public class ViewMenuProfessor {
	Professor professorLogado = entidades.Professor.buscarProfessorID(entidades.Professor.getIdLogado());
	
	public void menuProfessor(Scanner scanner) {
		for (int i = 0; i < 30; i++) System.out.println(" ");


		while (true) {
			System.out.println("\n=== Menu Professor/a " + professorLogado.getNome() + " ===");
			System.out.println("1 - Ver minhas turmas");
			System.out.println("2 - Ver alunos de uma turma");
			System.out.println("3 - Alterar nota de um aluno");
			System.out.println("4 - Voltar");
			System.out.print("Opção: ");
			String opcao = scanner.nextLine();


			switch (opcao) {
				case "1":
					verTurmas();
					break;
				case "2":
					verAlunosTurma(scanner);
					break;
				case "3":
					lancarOuAlterarNota(scanner);
					break;
				case "4":
					return;
				default:
					System.out.println("Opção inválida.");
			}
		}
	}


	public void verTurmas() {
		System.out.println("\n=== Minhas turmas ===");


		List<Turma> turmas = Turma.getTurmas();
		boolean tem = false;


		for (Turma t : turmas) {
			if (t.getNomeProfessor().equalsIgnoreCase(professorLogado.getNome())) {
				tem = true;
				System.out.println("Turma: " + t.getNomeTurma() + " | ID: " + t.getId() + " | Horário: " + t.getDiaHorario());
			}
		}


		if (!tem) System.out.println("Você não possui turmas cadastradas.");
	}


	public void verAlunosTurma(Scanner scanner) {
		System.out.println("\n=== Minhas turmas ===");

		List<Turma> turmas = Turma.getTurmas();
		boolean tem = false;

		for (Turma t : turmas) {
			if (t.getNomeProfessor().equalsIgnoreCase(professorLogado.getNome())) {
				tem = true;
				System.out.println("Turma: " + t.getNomeTurma() + " | ID: " + t.getId() + " | Horário: " + t.getDiaHorario());
			}
		}


		if (!tem) System.out.println("Você não possui turmas cadastradas.");
	    
		System.out.print("\nDigite o ID da turma: ");
		String id = scanner.nextLine();


		Turma turma = Turma.buscarTurmaPorId(id);
		if (turma == null) {
			System.out.println("Turma não encontrada.");
			return;
		}

		if (!turma.getNomeProfessor().equalsIgnoreCase(professorLogado.getNome())) {
			System.out.println("Você não é o professor desta turma.");
			return;
		}


		System.out.println("\n=== Alunos da turma " + turma.getNomeTurma() + " ===");
		if (turma.getAlunosTurma().isEmpty()) {
			System.out.println("Nenhum aluno matriculado.");
			return;
		}

		for (NotaAluno na : turma.getAlunosTurma()) {
			Aluno a = Aluno.buscarAlunoID(na.getId());
			if (a != null) {
				System.out.println("Aluno: " + a.getNome() + " | ID: " + a.getId() + " | Nota: " + na.getNota());
			}
		}
	}


	public void lancarOuAlterarNota(Scanner scanner) {
		System.out.println("\n=== Minhas turmas ===");

		List<Turma> turmas = Turma.getTurmas();
		boolean tem = false;

		for (Turma t : turmas) {
			if (t.getNomeProfessor().equalsIgnoreCase(professorLogado.getNome())) {
				tem = true;
				System.out.println("Turma: " + t.getNomeTurma() + " | ID: " + t.getId() + " | Horário: " + t.getDiaHorario());
			}
		}


		if (!tem) System.out.println("Você não possui turmas cadastradas.");
	    System.out.println("Digite o ID da turma:");
	    String idTurma = scanner.nextLine().trim();

	    Turma turma = Turma.buscarTurmaPorId(idTurma);
	    if (turma == null) {
	        System.out.println("Turma não encontrada.");
	        return;
	    }
	    if (!turma.getNomeProfessor().equalsIgnoreCase(professorLogado.getNome())) { 
	        System.out.println("Você não é o professor desta turma.");
	        return;
	    }
	    turma.listarAlunosDaTurma();

	    System.out.println("Digite o id do aluno na turma:");
	    String idAluno = scanner.nextLine().trim();

	    NotaAluno notaAluno = turma.buscarNotaAlunoPorId(idAluno);

	    if (notaAluno == null) {
	        System.out.println("Esse aluno não está matriculado nesta turma.");
	        return;
	    }

	    System.out.println("Aluno encontrado: " + notaAluno.getNome() +
	                       ", Nota atual: " + notaAluno.getNota());
	    System.out.println("Digite a nova nota: (Utilize ponto, Ex: 7.5)");

	    double novaNota = scanner.nextDouble();
	    scanner.nextLine();

	    notaAluno.setNota(novaNota);

	    System.out.println("Nota atualizada com sucesso!");
	    System.out.println("\nAluno: " + notaAluno.getNome() +
	                       ", Nota atual: " + notaAluno.getNota() +
	                       ", Aprovado: " + notaAluno.getAprovado());

	}
}