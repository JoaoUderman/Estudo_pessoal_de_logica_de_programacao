package excutavel;

import java.util.Scanner;

import entidades.Aluno;
import entidades.Turma;

public class Programa {
	public static boolean modoDeTeste = false;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("================================");	
			System.out.println("====Programa faculdade legal====");
			System.out.println("================================");
			System.out.println("\n Deseja usar o modo de testes?");
			System.out.println("Opções:");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			String opcao = scanner.nextLine();
			
			switch (opcao) {
				case "1":
					modoDeTeste = true;
					System.out.println("Inicicando o modo de testes...");
					criarObjetosAutomaticos();
					ViewMenuPrincipal.menuPrincipal();
					break;
				case "2":
					ViewMenuPrincipal.menuPrincipal();
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
	}
	public static void criarObjetosAutomaticos() {
		//Criar objetos automaticamente
		//Professores
		entidades.Professor.cadastrarProfessor("João Pedro", 30, "19348591248");
		entidades.Professor.cadastrarProfessor("Robson Silva", 45, "82757481032");
		
		//Turmas
		entidades.Turma.criarTurma("Ciências da Computação", "João Pedro", "Seg e ter 8:50 às 11:40");
		entidades.Turma.criarTurma("ADS", "Robson Silva", "Qua e Sex 20:00 às 22:50");
		
		//Alunos
		entidades.Aluno.cadastrarAlunos("Cleiton Pereira", 22, "04", "29485710284");
		entidades.Aluno.cadastrarAlunos("Bruno Alves", 25, "09", "529764827632");
		entidades.Aluno.cadastrarAlunos("Maria Eduarda", 19, "02", "73412093851");
		
		//Cadastro aluno turma
			//Aluno 1
			Turma turmaEncontrada1 = entidades.Turma.buscarTurmaPorId("T001");
			Aluno alunoCriado1 = entidades.Aluno.buscarAlunoID("A294001");
			turmaEncontrada1.adicionarAluno(alunoCriado1);
			//Aluno 2
			Turma turmaEncontrada2 = entidades.Turma.buscarTurmaPorId("T002");
			Aluno alunoCriado2 = entidades.Aluno.buscarAlunoID("A529002");
			turmaEncontrada2.adicionarAluno(alunoCriado2);
			//Aluno 3
			Turma turmaEncontrada3 = entidades.Turma.buscarTurmaPorId("T001");
			Turma turmaEncontrada3_2 = entidades.Turma.buscarTurmaPorId("T002");
			Aluno alunoCriado3 = entidades.Aluno.buscarAlunoID("A734003");
			turmaEncontrada3.adicionarAluno(alunoCriado3);
			turmaEncontrada3_2.adicionarAluno(alunoCriado3);
	}
}
