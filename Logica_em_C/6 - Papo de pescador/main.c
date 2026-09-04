#include <stdio.h>

/* João Papo-de-Pescador, homem de bem, comprou um microcomputador
para controlar o rendimento diário de seu trabalho. Toda vez que ele traz
um peso de peixes maior que o estabelecido pelo regulamento de pesca do
estado de São Paulo (50 quilos) deve pagar uma multa de R$ 4,00 por quilo
excedente. João precisa que você faça um programa que leia a variável peso
(peso de peixes) e calcule o excesso. Gravar na variável excesso a
quantidade de quilos além do limite e na variável multa o valor da multa
que João deverá pagar. Imprima os dados do programa com as mensagens
adequadas.*/

/* regulamento 50kg
 * multa 4 reais por kg excedente
 * variaveis: pesp, excesso e multa
 */

int main(void) {
#define taxa 4.0
#define max 50.0
    float peso, excesso, multa;
    int x = 0, resp;
    while (1) {
        peso = 0;
        x = 0;
        while (x != 1 || peso < 0) {
            printf("\nInsira o peso do peixe pescado: \n(lembrete: regulamento: max 50 kg e R$ 4 por kg excedente \n ");
            x = scanf("%f", &peso);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: digite apenas numeros! \n");
            } else if (peso < 0) {
                printf("\nErro: digite apenas valores inteiros! \n");
            }
        }
        if (peso <= 50) {
            printf("Valor dentro do regulamento! \n Sem cobrança de taxa!");
        } else {
            excesso = peso - 50.0;
            multa = taxa * excesso;
            printf("\nValor de excesso do peixe: %.2f \n", excesso);
            printf("Valor da multa: RS %.2f \n", multa);
        }
        while (1) {
            printf("\n Deseja inserir peso de outro peixe? \n");
            printf("1 - Sim \n2 - Nao \n");
            scanf("%d", &resp);
            while (getchar() != '\n');
            switch (resp) {
                case 1: {
                    break;
                }
                case 2: {
                    return 0;
                }
                default: {
                    printf("Opcao invalida! \n");
                }
            }
            if (resp == 1) {
                break;
            }
        }
    }
}