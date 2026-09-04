import java.util.Scanner;
/* Programa simples o qual você digita seu nome completo e o programa identifica quais letras 
   devem ser maiusculas e quando imprime, independente de como foi digitado, o nome aparece com 
   os caracteres iniciais de cada nome maiusculas.
 */

public class main {

	static String nomeOriginal;
	static String nomeModificado;
	static int tamanhoNome;
	static int[] posicaoMaiuscula = new int[15];
	static int cont;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		nomeOriginal = sc.nextLine();
		tamanhoNome = nomeOriginal.length();
		cont = 1;
		
		/// Gravação de maiusculos
		for (int i = 0; i < tamanhoNome; i++) {
			
			char letra = nomeOriginal.charAt(i);
			if ((letra == ' ') && (i + 1 < tamanhoNome) && (nomeOriginal.charAt(i + 1) != ' ') 
					&& (nomeOriginal.charAt(i + 2) != ' ') && (nomeOriginal.charAt(i + 3) != ' ')) {
				posicaoMaiuscula[cont] = i + 1;
				cont++;
			}
		}

		/// Imprimir nome em maiusculo
		cont = 0;
		for (int i = 0; i < nomeOriginal.length(); i++) {
			if (i == 0 || i == posicaoMaiuscula[cont]) {
				System.out.print(Character.toUpperCase(nomeOriginal.charAt(i)));
				cont++;
			} else {
				System.out.print(nomeOriginal.charAt(i));
			}
		}

		cont = 0;
		System.out.println();

		imprimirVetor();

	}

	public static void imprimirVetor() {
		for (int i = 0; i < 14; i++) {
			if (i == 0) {
				System.out.print(posicaoMaiuscula[i] + ", ");
			}
			if (posicaoMaiuscula[i] != 0) {
				if (posicaoMaiuscula[i + 1] != 0) {
					System.out.print(posicaoMaiuscula[i] + ", ");
				} else {
					System.out.print(posicaoMaiuscula[i] + ".");
				}
			}
		}
	}
	
	//teste comit1

}
