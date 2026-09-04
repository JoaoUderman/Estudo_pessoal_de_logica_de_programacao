#include <stdio.h>
#include <locale.h>
#include <stdlib.h>
/* 10.Faça um Programa para um caixa eletrônico. O programa deverá perguntar
ao usuário a valor do saque e depois informar quantas notas de cada valor
serão fornecidas.

As notas disponíveis serão as de 1, 5, 10, 50 e 100 reais. O valor mínimo é
de 10 reais e o máximo de 600 reais. O programa não deve se preocupar
com a quantidade de notas existentes na máquina.

Exemplo 1: Para sacar a quantia de 256 reais, o programa fornece duas
notas de 100, uma nota de 50, uma nota de 5 e uma nota de 1;

Exemplo 2: Para sacar a quantia de 399 reais, o programa fornece três
notas de 100, uma nota de 50, quatro notas de 10, uma nota de 5 e quatro
notas de  */
int main(void) {
    setlocale(LC_ALL, "Portuguese");

    int x, valor, n100, n50, n10, n5, n1, resp;

    while (1) {
        n100 = 0;
        n50 = 0;
        n10 = 0;
        n5 = 0;
        n1 = 0;
        resp = 0;
        do {
            printf("\nDigite o valor a ser sacado: \n ");
            printf("(min:R$ 10 máx:600\n");
            x = scanf("%d", &valor);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: digite apenas numeros \n");
            } else if ( valor < 0 || valor > 600) {
                printf("\nErro: digite valores entre o máximo e minímo!\n");
            }
        } while (x != 1 || valor < 0 || valor > 600);

        if ( valor > 99) {
            n100 = valor / 100;
            valor = valor % 100;
        }
        if (valor > 49) {
            n50 = valor / 50;
            valor = valor % 50;
        }
        if (valor > 9) {
            n10 = valor / 10;
            valor = valor % 10;
        }
        if (valor > 4) {
            n5 = valor / 5;
            valor = valor % 5;
        }
        if (valor > 0) {
            n1 = valor;
            valor -= valor;
        }
        printf("\n---------------------------------- \n");
        if (n100 > 0) {
            printf("Notas de 100: %d\n",n100);
        }
        if (n50 > 0) {
            printf("Notas de 50: %d\n",n50);
        }
        if (n10 > 0) {
            printf("Notas de 10: %d\n",n10);
        }
        if (n5 > 0) {
            printf("Notas de 5: %d\n",n5);
        }
        if (n1 > 0) {
            printf("Notas de 1: %d\n",n1);
        }
        while (1) {
            printf("\n Deseja repetir? \n");
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
                system("cls");
                break;
            }
        }
    }
}