package excutavel;

import java.util.List;
import java.util.Scanner;

import entidades.Aluno;
import entidades.Diretor;
import entidades.NotaAluno;
import entidades.Turma;

public class ViewMenuAluno {
	Aluno alunoEncontrado = entidades.Aluno.buscarAlunoID(entidades.Aluno.getIdAlunoLogado()); 
	public void menuAluno(Scanner scanner) {
		for (int i = 0; i < 30; i++) {
			System.out.println(" ");
		}
		while (true) {
			System.out.println("\n=== Menu aluno/a " + alunoEncontrado.getNome() + " ===");
			System.out.println("Digite sua opcção:");
			System.out.println("1 - Ver minhas turmas e aulas");
			System.out.println("2 - Ver minha nota");
			System.out.println("3 - Ver contato do diretor");
			System.out.println("4 - Voltar");
			System.out.println("Opção:");
			String opcao = scanner.nextLine();
			switch (opcao) {
				case "1":
					verTurmas();
					break;
				case "2":
					verNotas();
					break;
				case "3":
					Diretor diretor = new Diretor("Vanderson", 54, "D734001", "(71)9765-8323");
					System.out.println(diretor.contato());
					break;
				case "4":
					return;
				default:
					System.out.println("Opção inválida");
			}
		}
	}
	
	public void verTurmas() { 
		System.out.println("\n=== Lista de turmas de " + alunoEncontrado.getNome() + " ===");
		
		List<Turma> listaTurmas = entidades.Turma.getTurmas();
		
		if (listaTurmas.isEmpty()) {
			System.out.println("Nunhuma turma cadastrada no sitema");
			return;
		}
		
		boolean temTurma = false;
		
		for (Turma turma : listaTurmas) {
			for (NotaAluno na : turma.getAlunosTurma()) {
				if (na.getId().equalsIgnoreCase(alunoEncontrado.getId())) {
					temTurma = true;
					System.out.println("Turma " + turma.getNomeTurma() + ", ID: " + turma.getId() + ", Professor : " + turma.getNomeProfessor() + ", Horário " + turma.getDiaHorario());
				}
			}
		}
		if (!temTurma) {
            System.out.println("Você não está matriculado em nenhuma turma.");
        }
	}
	
	public void verNotas() {
		System.out.println("\n=== Lista de turmas de " + alunoEncontrado.getNome() + " ===");
				
			List<Turma> listaTurmas = entidades.Turma.getTurmas();
			
			if (listaTurmas.isEmpty()) {
				System.out.println("Nunhuma turma cadastrada no sitema");
				return;
			}
			
			boolean temTurma = false;
			
			for (Turma turma : listaTurmas) {
				for (NotaAluno na : turma.getAlunosTurma()) {
					if (na.getId().equalsIgnoreCase(alunoEncontrado.getId())) {
						temTurma = true;
						System.out.println("\nTurma " + turma.getNomeTurma() + ", ID: " + turma.getId() + ", Professor : " + turma.getNomeProfessor() + ", Horário " + turma.getDiaHorario());
						System.out.println("Nota: " + na.getNota() + ", Aprovado: " + na.getAprovado());
					}
				}
			}
			if (!temTurma) {
	            System.out.println("Você não está matriculado em nenhuma turma.");
	        }
		}
}
