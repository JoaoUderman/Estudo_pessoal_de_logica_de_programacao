#include <stdio.h>
#include <math.h>
/*5. Dado N, verifique se é um número narcisista ou não.
Nota: Número narcisista é um número que é a soma de seus próprios
dígitos, cada um elevado à potência do número de dígitos Exemplos:

Entrada: 153
Saída: sim
Explicação: 1 ^ 3 + 5 ^ 3 + 3 ^ 3 = 153 Entrada: 1634
Saída: sim
Explicação: 1 ^ 4 + 6 ^ 4 + 3 ^ 4 + 4 ^ 4 = 1634 5 - Escreva um programa que
simule uma calculadora, onde a operação a ser realizada deve ser escolhida
partir de um menu de opções*/
int N, n1, x, r, s = 0, dig;
int main(void) {
    while (1) {
        printf("=== Calculadora do narcisista ===\n");
        printf("Digite a sua opcao: \n 1 - Verificar numero \n 2 - Sair\n");
        x = scanf("%d", &r);
        switch (r) {
            case 1: {
                verificador();
                break;
            }
            case 2: {
                return 0;
            }
            default: {
                printf("Opcao invalidan\n");
            }
        }
        while (getchar() != '\n');

    }
    return 0;
}
int verificador(void) {
    while (1) {
        printf("Digite o valor a ser verificado: (max 99.999) \n");
        x = scanf("%d", &N);
        if (x != 1) {
            printf("Erro: digite um numero\n");
            while (getchar() != '\n');
        }
        else if (N < 1) {
            printf("Erro: numero fora do intervalo\n");
        } else {
            break;
        }
    }
    x = N;
    if (N > 9999) {
        dig = 5;
    } else if (N > 999) {
        dig = 4;
    } else if (N > 99) {
        dig = 3;
    } else if (N > 9) {
        dig = 2;
    } else {
        dig = 1;
    }
    if (N > 9999) {
        n1 = (N / 10000);
        N = N % 10000;
        s = s + (pow(n1, dig));
    }
    if (N > 999) {
        n1 = (N / 1000);
        N = N % 1000;
        s = s + (pow(n1, dig));
    }
    if (N > 99) {
        n1 = (N / 100);
        N = N % 100;
        s = s + (pow(n1, dig));
    }
    if (N > 9) {
        n1 = (N / 10);
        N = N % 10;
        s = s + (pow(n1, dig));
    }
    if (N > 0) {
        s = s + (pow(N, dig));
    }
    if (s == x) {
        printf("O numero e narcisista\n");
    } else {
        printf("O numero nao e narcisita\n");
    }
    main();
    return 0;
}