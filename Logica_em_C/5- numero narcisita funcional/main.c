#include <stdio.h>
#include <locale.h>
#include <math.h>
#include <string.h>


/* Dado N, verifique se é um número narcisista ou não.
Nota: Número narcisista é um número que é a soma de seus próprios
dígitos, cada um elevado à potência do número de dígitos Exemplos:

Entrada: 153
Saída: sim
Explicação: 1 ^ 3 + 5 ^ 3 + 3 ^ 3 = 153 Entrada: 1634
Saída: sim
Explicação: 1 ^ 4 + 6 ^ 4 + 3 ^ 4 + 4 ^ 4 = 1634 5 - Escreva um programa que
simule uma calculadora, onde a operação a ser realizada deve ser escolhida
partir de um menu de opções*/

int x, resp, n, qDig, nAtual, total, n1, rest;

int main(void) {
    setlocale(LC_ALL,"Portuguese");
    //não funcionou
    while (1) {
        printf("=== Calculadora do narcisita ===");
        printf("Digite sua opção: \n 1 - Verificar número \n 2 - sair \n");
        scanf("%d", &resp);
        fflush(stdin);
        switch (resp) {
            case 1: {
                verificador();
                break;
            }
            case 2: {
                return 0;
            }
            default: {
                printf("Opção invalída\n");
            }
        }
    }
    return 0;
}
int verificador(void) {
    total = 0;
    while (1) {
        printf("Digite o valor a ser verificado: (max 99.999 \n");
        x = scanf("%d", &n);
        fflush(stdin);
        if (x != 1) {
            printf("Erro: Digite apenas numeros\n");
        } else if (n < 1 || n > 99999) {
            printf("Erro: numero fora do intervalo");
        } else {
            break;
        }
    }
    n1 = n;
    if (n > 9999) {
        qDig = 5;
    } else if (n > 999) {
        qDig = 4;
    } else if (n > 99) {
        qDig = 3;
    } else if (n > 9) {
        qDig = 2;
    } else {
        qDig = 1;
    }

    if (n > 9999) {
        nAtual = n / 10000;
        rest = n % 10000;
        n = rest;
        total = total + (pow(nAtual, qDig));
    }
    if ( n > 999) {
        nAtual = n / 1000;
        rest = n % 1000;
        n = rest;
        total = total + (pow(nAtual, qDig));
    }
    if (n > 99) {
        nAtual = n / 100;
        rest = n % 100;
        n = rest;
        total = total + (pow(nAtual, qDig));
    }
    if (n > 9) {
        nAtual = n / 10;
        rest = n % 10;
        n = rest;
        total = total + (pow(nAtual, qDig));
    }
    if ( n > 0) {
        total = total + (pow(n, qDig));
    }
    if (total == n1) {
        printf("O numero e narcisita \n");
    } else {
        printf("O numero nao e narcisista! \n");
    }
    //printf("\n numero: %d \n total: %d \n",n1,total);
    //printf("\n nAtual: %d \n rest: %d \n total: %d \n digito: %d \n", nAtual, rest, total, qDig);
}