import java.util.Scanner;

public class Program {
	
	//Codigo escrito apenas como forma de estudo, para poder relembrar Java, metodos e funções.

	/*o codigo apresenta um bug sobre a ordem dos jogadores, 
	 * a depender do numero da jogada do vencedor, possa ser que o jogador inicial da proxima partida
	 * seja o mesmo da partida anterior.
	 */
	static Scanner sc = new Scanner(System.in);

	static String[][] tabuleiro = { { "7", "8", "9" }, { "4", "5", "6" }, { "1", "2", "3" } };
	static boolean jogo = true;
	static boolean fimJogo = false;
	static boolean respValida = false;
	static int contVez;
	static int contJogadas = 0;
	static int contX;
	static int contO;
	static String vencedor;

	public static void main(String[] args) {

		do {
			reniciarMatriz();
			contJogadas = 0;
			contX = 0;
			contO = 0;
			imprimirInicio();
			limparTela();

			// Ciclo da partida atual
			do {

				respValida = false;
				if (contJogadas != 0) {
					limparTela();
				}
				imprimirTabuleiro();
				imprimirJogador();
				centralizarTela();

				// procurar numero na tabela
				while (!respValida) {
					String jogada = sc.nextLine();
					for (int i = 0; i < tabuleiro.length; i++) {
						for (int j = 0; j < tabuleiro.length; j++) {
							if (tabuleiro[i][j].equals(jogada)) {
								respValida = true;
								tabuleiro[i][j] = jogador(contVez);
								contVez++;
								break;
							}
						}
						if (respValida) {
							break;
						}
					}
					if (!respValida) {
						System.out.println("Erro, digite numeros disponiveis na tabela!");
					}
				}

				contJogadas++;

				// procurar vencedor em linha
				contX = 0;
				contO = 0;
				for (int i = 0; i < tabuleiro.length; i++) {
					for (int j = 0; j < tabuleiro.length; j++) {
						if (tabuleiro[i][j].equals("X")) {
							contX++;
						}
						if (tabuleiro[i][j].equals("O")) {
							contO++;
						}
						if (contX >= 3) {
							break;
						}
						if (contO >= 3) {
							break;
						}
					}
					if (contX >= 3) {
						break;
					}
					if (contO >= 3) {
						break;
					}
					contX = 0;
					contO = 0;
				}
				imprimirVencedor();
				if (contX >= 3) {
					break;
				}
				if (contO >= 3) {
					break;
				}

				// TENTER OTIMIZAR O LOOP COLANDO BREAK EM CADA CONTx/CONTo E DEIXANDO O
				// VERIFICADOR DE 3 APENAS NO OUTRO FOR

				// procurar vencedor em coluna
				contX = 0;
				contO = 0;
				for (int i = 0; i < tabuleiro.length; i++) {
					for (int j = 0; j < tabuleiro.length; j++) {
						if (tabuleiro[j][i].equals("X")) {
							contX++;
						}
						if (tabuleiro[j][i].equals("O")) {
							contO++;
						}
						if (contX >= 3) {
							break;
						}
						if (contO >= 3) {
							break;
						}
					}
					if (contX >= 3) {
						break;
					}
					if (contO >= 3) {
						break;
					}
					contX = 0;
					contO = 0;
				}
				imprimirVencedor();
				if (contX >= 3) {
					break;
				}
				if (contO >= 3) {
					break;
				}
				/*
				 * // prucurar vencedor diagonal principal contX = 0; contO = 0; for (int i = 0;
				 * i < tabuleiro.length; i++) { for (int j = 0; j < tabuleiro.length; j++) { if
				 * (i == j) { if (tabuleiro[i][j].equals("X")) { contX++; } if (tabuleiro
				 * [i][j].equals("O")) { contO++; } } } if (contX >= 3) { break; } if (contO >=
				 * 3) { break; } }
				 */

				// procurar vencedor diagonal principal modo pratico
				contX = 0;
				contO = 0;
				for (int i = 0; i < tabuleiro.length; i++) {
					if (tabuleiro[i][i].equals("X")) {
						contX++;
					}
					if (tabuleiro[i][i].equals("O")) {
						contO++;
					}
				}
				imprimirVencedor();
				if (contX >= 3) {
					break;
				}
				if (contO >= 3) {
					break;
				}

				// procurar vencedor diagonal secundaria
				contX = 0;
				contO = 0;
				for (int i = 0; i < tabuleiro.length; i++) {
					for (int j = 0; j < tabuleiro.length; j++) {
						if (i + j == 2) {
							if (tabuleiro[i][j].equals("X")) {
								contX++;
							}
							if (tabuleiro[i][j].equals("O")) {
								contO++;
							}
						}
					}
				}
				imprimirVencedor();
				if (contX >= 3) {
					break;
				}
				if (contO >= 3) {
					break;
				}
				/*
				 * solução da IA para estudar futuramente: for (int i = 0; i < tabuleiro.length;
				 * i++) {
				 * 
				 * if (tabuleiro[i][tabuleiro.length - 1 - i].equals("X")) { contX++; }
				 * 
				 * if (tabuleiro[i][tabuleiro.length - 1 - i].equals("O")) { contO++; } }
				 */

			} while (contJogadas <= 8);

			if (contJogadas == 9 && contX < 3 && contO < 3) {
				limparTela();
				System.out.println("===========================");
				System.out.println("        Deu velha");
				System.out.println("       Fim de Jogo!");
				System.out.println("===========================");
				System.out.println(" ");
				System.out.println("Digite qualquer tecla para continuar.");
				centralizarTela();
				sc.nextLine();
			}

		} while (jogo);

	}

	public static void imprimirTabuleiro() {

		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (j < 2) {
					System.out.print(tabuleiro[i][j]);
				} else {
					System.out.println(tabuleiro[i][j]);
				}
				if (j < 2) {
					System.out.print(" | ");
				}
			}
			if (i < 2) {
				System.out.println("----------");
			}
		}
	}

	public static void imprimirVencedor() {
		limparTela();
		if (contX >= 3) {
			imprimirTabuleiro();
			System.out.println(" ");
			System.out.println("======================");
			System.out.println("   PARABÉNS JOGADOR");
			System.out.println("           X");
			System.out.println("     Você venceu!");
			System.out.println("======================");
			centralizarTela();
			System.out.println(" ");
			System.out.println("Digite qualquer tecla para continuar.");
			centralizarTela();
			sc.nextLine();
		} else if (contO >= 3) {
			imprimirTabuleiro();
			System.out.println(" ");
			System.out.println("======================");
			System.out.println("   PARABÉNS JOGADOR");
			System.out.println("           O");
			System.out.println("     Você venceu!");
			System.out.println("======================");
			centralizarTela();
			System.out.println(" ");
			System.out.println("Digite qualquer tecla para continuar.");
			centralizarTela();
			sc.nextLine();
		}
	}

	public static String jogador(int c) {
		String jog;
		if (c % 2 == 0 || c == 0) {
			jog = "X";
		} else {
			jog = "O";
		}
		return jog;
	}

	public static void imprimirJogador() {

		System.out.println(" ");
		if ((contVez == 0) || (contVez % 2 == 0)) {
			System.out.println("O jogador atual é X");
		} else {
			System.out.println("O jogador atual é O");
		}
	}

	public static void limparTela() {
		for (int i = 0; i < 50; i++) {
			System.out.println(" ");
		}
	}

	public static void centralizarTela() {
		for (int i = 0; i < 8; i++) {
			System.out.println(" ");
		}
	}

	public static void imprimirInicio() {
		limparTela();
		System.out.println("===================================");
		System.out.println("            Bem-vindo");
		System.out.println("                ao");
		System.out.println("          JOGO DA VELHA");
		System.out.println("===================================");

		System.out.println("Deseja jogar? [S] [N]");

		centralizarTela();

		String resp = sc.next();
		sc.nextLine();
		jogo = revisaoRespSN(resp);
	}

	public static boolean revisaoRespSN(String R) {

		boolean SN;
		String Re = R.toUpperCase();
		do {
			if (!Re.equals("S") && !Re.equals("N")) {
				System.out.println("Digite apena [S] ou [N]");
				SN = false;
				Re = sc.next();
				sc.nextLine();
				Re = Re.toUpperCase();
			} else {
				SN = true;
			}
		} while (SN == false);

		if (Re.equals("N")) {
			System.out.println("========================");
			System.out.println("  Encerrando programa!");
			System.out.println("========================");
			System.exit(0);
			SN = false;
		}
		limparTela();
		return SN;
	}

	public static void reniciarMatriz() {
		int contPosicao = 1;
		for (int i = 2; i >= 0; i--) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = Integer.toString(contPosicao);
				contPosicao++;
			}
		}
	}

}
