package Executavel;

import java.util.Scanner;

public class programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean Temp = false, Din = false, Ener = false, Resp;
		String True, False;
		int cont;

		True = "[||||||||||]";
		False = "[          ]";
		while (true) {
			Resp = false;
			cont = 0;
			System.out.println("========================================================");
			System.out.println(" Tabela Verdade: Você não pode ter os 3 ao mesmo tempo!");
			System.out.println("              Escolha e teste você mesmo!");
			System.out.println("========================================================\n");
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
			System.out.println("\n Digite o que deseja:");
			while (Resp == false) {
				System.out.println("\n Deseja Tempo?");
				System.out.println("1- Sim");
				System.out.println("2- Não");
				System.out.println("3- Sair");
				String opcao = sc.next();

				switch (opcao) {
				case "1":
					Temp = true;
					cont ++;
					break;
				case "2":
					Temp = false;
					break;
				case "3":
					return;
				default:
					System.out.println("Opção inválida.");
					break;
				}
				Resp = true;
			}
			Resp = false;
			while (Resp == false) {
				System.out.println("\n Deseja Dinheiro?");
				System.out.println("1- Sim");
				System.out.println("2- Não");
				System.out.println("3- Sair");
				String opcao = sc.next();

				switch (opcao) {
				case "1":
					Din = true;
					cont ++;
					break;
				case "2":
					Din = false;
					break;
				case "3":
					return;
				default:
					System.out.println("Opção inválida.");
					break;
				}
				Resp = true;
			}
			Resp = false;
			while (Resp == false) {
				System.out.println("\n Deseja Energia?");
				System.out.println("1- Sim");
				System.out.println("2- Não");
				System.out.println("3- Sair");
				String opcao = sc.next();

				switch (opcao) {
				case "1":
					Ener = true;
					cont ++;
					break;
				case "2":
					Ener = false;
					break;
				case "3":
					return;
				default:
					System.out.println("Opção inválida.");
					break;
				}
				Resp = true;
			}
			if (cont == 3) {
				System.out.println("\n Como dito anteriomente, VOCÊ NÃO PODE TER OS 3 AO MESMO TEMPO!");
				System.out.println("Por favor, escolha apenas 2 ao mesmo tempo!\n");
				Temp = false;
				Din = false;
				Ener = false;
			}
		}

	}
}