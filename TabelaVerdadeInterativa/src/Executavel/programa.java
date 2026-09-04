package Executavel;

import java.util.Scanner;

public class programa {
	Scanner sc = new Scanner(System.in);
	static boolean Temp = false;
	static boolean Din = false;
	static boolean Ener = false;
	static int cont = 0;;
	static String True;
	static String False;
	static String idade = "/";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (cont == 0) {
			tabela();
		}
		while (true) {
			System.out.println("\nDigite qual deseja:");
			System.out.println("1 - Tempo");
			System.out.println("2 - Dinheiro");
			System.out.println("3 - Energia");
			System.out.println("4 - Sair");
			String opcao = sc.next();
			switch (opcao) {
			case "1":
				if (cont == 0) {
					cont++;
					Temp = true;
					break;
				} else if (Temp == true) {
					System.out.println("\n Você já tem tempo!\n");
				} else if (Din == true && Ener == false) {
					Temp = true;
				} else if (Din == false && Ener == true) {
					Temp = true;
				} else if (Din == true && Ener == true) {
					Temp = true;
					Ener = false;
					break;
				}
				break;				
			case "2":
				if (cont == 0) {
					cont ++;
					Din = true;
					break;
				} else if (Din == true) {
					System.out.println("\n Você já tem dinheiro!\n");
				} else if (Temp == true && Ener == false) {
					Din = true;
					break;
				} else if (Temp == false && Ener == true) {
					Din = true;	
					break;
				} else if (Temp == true && Ener == true) {
					Din = true;
					Temp = false;
					break;
				}
				break;
			case "3":
				if (cont == 0) {
					cont ++;
					Ener = true;
					break;
				} else if (Ener == true) {
					System.out.println("\n Você já tem energia!\n");
				} else if (Temp == true && Din == false) {
					Ener = true;
					break;
				} else if (Temp == false && Din == true) {
					Ener = true;
					break;
				} else if (Temp == true && Din == true) {
					Ener = true;
					Din = false;
					break;
				}
				break;
			case "4":
				System.exit(0);
			}
			if (cont != 0) {
				if (Temp == true && Din == true) {
					idade = "Idoso";
				} else if (Temp == true && Ener == true) {
					idade = "Jovem";
				} else if (Din == true && Ener == true) {
					idade = "Adulto";
				}
			}
			tabela();
		}
	}

	public static void tabela() {
		True = "[||||||||||]";
		False = "[          ]";
		if (Temp == false) {
			System.out.println("Tempo   : " + False);
		} else {
			System.out.println("Tempo   : " + True);
		}
		if (Din == false) {
			System.out.println("Dinheiro: " + False);
		} else {
			System.out.println("Dinheiro: " + True);
		}
		if (Ener == false) {
			System.out.println("Energia : " + False);
		} else {
			System.out.println("Energia : " + True);
		}
		System.out.println("Você é: " + idade);
		return;
	}

}
