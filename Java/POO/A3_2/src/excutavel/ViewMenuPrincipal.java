package excutavel;

import java.util.Scanner;

import entidades.Diretor;
import entidades.Professor;

public class ViewMenuPrincipal {
	public static void menuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 30; i++) {
			System.out.println(" ");
		}
		while (true) {
			System.out.println("\n=== Sistema de Faculdade ===");
			System.out.println("Digite a sua opção:");
			System.out.println("1 - Aluno");
			System.out.println("2 - Professor");
			System.out.println("3 - Coordenador");
			System.out.println("4 - Ligar/Desligar mode de teste");
			System.out.println("5 - Encerrar Sistema");
			System.out.print("Opção: ");
			String opcao = scanner.nextLine().trim();

			switch (opcao) {
			case "1":
				System.out.println("Informe o seu ID de aluno");
				if (Programa.modoDeTeste) {
					ViewMenuDiretor.listarAlunos(scanner);
				}
				String idGerado = scanner.nextLine();
				boolean existe = entidades.Aluno.verificadorIdAluno(idGerado);
				if (existe) {
					System.out.println("ID correto");
					new ViewMenuAluno().menuAluno(scanner);
					break;
				} else {
					System.out.println("ID incorreto");
					continue;
				}
			case "2":
				System.out.println("Informe o seu ID de professor: ");
				if (Programa.modoDeTeste) {
					ViewMenuDiretor.listarProfessores(scanner);
				}
				idGerado = scanner.nextLine();
				existe = entidades.Professor.verificadorIdProfessor(idGerado);
				if (existe) {
					System.out.println("ID correto");
					new ViewMenuProfessor().menuProfessor(scanner); // Abre o menu professor
					break;
				} else {
					System.out.println("ID incorreto");
					break;
				}

			case "3":
				System.out.println("Informe o seu ID de Diretor: ");
				Diretor diretor = new Diretor("Vanderson", 54, "D734001", "(71)9765-8323");
				if (Programa.modoDeTeste) {
					System.out.println("ID diretor: " + diretor.getId());;
				}
				idGerado = scanner.nextLine();
				if (diretor.verificadorIdDiretor(idGerado)) {
					System.out.println("ID correto");
					ViewMenuDiretor.menuCoordenador(scanner); // Abre o menu coordenador
					break;
				} else {
					System.out.println("ID incorreto");
					break;
				}
			case "4":
				Programa.modoDeTeste = !Programa.modoDeTeste;
				if (Programa.modoDeTeste) {
					System.out.println("Modo de teste ligado");
				} else {
					System.out.println("Modo de teste desligado");
				}
				break;
			case "5":
				System.out.println("Saindo do sistema...");
				scanner.close();
				return; // Sai do sistema
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}
}
