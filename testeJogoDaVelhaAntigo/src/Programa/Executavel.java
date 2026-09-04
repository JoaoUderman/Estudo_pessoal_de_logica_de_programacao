package Programa;

import java.util.Scanner;

public class Executavel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, l, rc,contX, contO, testF = 0, contJ = 1;
		String r;
		String[][] mat= {
			    {"1","2","3"},
			    {"4","5","6"},
			    {"7","8","9"}
			};
		//Imprimir matriz
		for (i = 0; i < mat.length; i++) {
			System.out.print("| ");
			for(j = 0;j < mat[i].length; j++) {
				System.out.printf("%2s |", mat[i][j]);
			}
			System.out.println();
		}
		//Entrar no loop até encontrar vencedor ou dar velha
		do {
		//rc é para saber se a posição foi valida
		rc = 0;
		//loop de receber resposta da posição
		do{
			//jogador X
			if (contJ % 2 != 0) {
					System.out.print("Escolha a posição para jogar (X)");
					r = sc.next();
			for (i = 0; i < mat.length; i++) {
				for(j = 0;j < mat[i].length; j++) {
					//teste de resposta
					if (r.equals(mat[i][j])) {
						mat[i][j] = "X";
						rc ++;
						contJ ++;
		
					}
				}
			}
		} else {
			//jogador O
			if (contJ % 2 == 0) {
				System.out.println("Escolha a posição para jogar (O)");
				r = sc.next();
				for (i = 0; i < mat.length; i++) {
					for(j = 0;j < mat[i].length; j++) {
						if (r.equals(mat[i][j])) {
							mat[i][j] = "O";
							rc ++;
							contJ++;
							}
						}
					}
			}
		}
		//contJ é usado para saber a vez de quem joga, sendo X jogadas impares e O jogadas pares
		//while (rc == 0) é usado, pois o rc só é acrescentado quando uma resposta válida é dada
		} while (rc == 0);
		//limpar a tela
		for (i = 0; i < 50; i++) {
	        System.out.println();
	    }
		//imprimir o jogo
		for (i = 0; i < mat.length; i++) {
			System.out.print("| ");
			for(j = 0;j < mat.length; j++) {
				System.out.printf("%2s |", mat[i][j]);
			}
			System.out.println();
		}
		//inicio dos testes
		contX = 0;
		contO = 0;
		//teste diagonal principal
		for (i = 0; i < mat.length; i++) {
			if (mat[i][i] == "X") {
				contX ++;
			}
			if (mat[i][i] == "O") {
				contO ++;
			}
		}
		if ((contX == 3) || (contO == 3)) {
			testF ++;
			break;
		}
		//teste diagonal secundaria
		contX = 0;
		contO = 0;
		for (i = 0; i < mat.length; i++) {
			for(j = 0; j < mat[i].length; j++) {
				if (i + j == 2) {
					if (mat[i][j] == "X") {
						contX ++;
					}
					if (mat[i][j] == "O") {
						contO ++;
					}
				}
			}
		}
		if ((contX == 3) || (contO == 3)) {
			testF ++;
			break;
		}
		//teste linha
		contX = 0;
		contO = 0;
		for (i = 0; i < mat.length; i++) {
			if ((contX == 3) || (contO == 3)) {
				testF ++;
				break;
			}
			contX = 0;
			contO = 0;
			for(j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == "X") {
					contX ++;
				}
				if (mat[i][j] == "O") {
					contO ++;
				}
				if ((contX == 3) || (contO == 3)) {
					testF ++;
					break;
			}
		}
		}
		if ((contX == 3) || (contO == 3)) {
			break;
		}
		//teste coluna
		contX = 0;
		contO = 0;
		for (i = 0; i < mat.length; i++) {
			if ((contX == 3) || (contO == 3)) {
				testF ++;
				break;
			}
			contX = 0;
			contO = 0;
			for(j = 0; j < mat[i].length; j++) {
				//eu usei o mesmo raciocinio da linha para testar as colunas, só invertir o i pelo j, pois assim ele segue primeiro a coluna inves da linha
				if (mat[j][i] == "X") {
					contX ++;
				}
				if (mat[j][i] == "O") {
					contO ++;
				}
				if ((contX == 3) || (contO == 3)) {
					testF ++;
					break;
			}
		}
		}
		if ((contX == 3) || (contO == 3)) {
			break;
		}
		//while usado para caso não seja encontrado vencedor e de velha 
		} while (contJ <= 9);
		//testes de respostas
		if (testF == 0) {
			System.out.println("Deu velha");
		} else {
			if (contX >= 3) {
				System.out.println("X ganhou");
			} else {
				System.out.println("O ganhou");
			}
		}
}
}