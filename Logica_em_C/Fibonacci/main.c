#include <stdio.h>

int main(void) {
    /* O próximo termo da sequência de Fibonacci é definido como a soma dos
últimos dois termos da sequência, sendo que os dois primeiros dois termos
da sequência são:
1 e 1. Assim o terceiro termo é 1 + 1 = 2
O quarto termo é 1 + 2 = 3  O quinto
termo é 2 + 3 = 5.
Dessa forma para N = 6 estes são os termos da sequência de FIbonacci
1, 1, 2, 3, ,5, 8
Faça um programa que calcule e imprima os N primeiros termos da
sequência de Fibonacci, onde N é definido pelo usuário. */

    int n1 = 0, n2 = 1, N, resp = 1, s;
    int i, x;
    while (resp == 1) {
        printf("Digite a quantidade de termos da sequência de Fibonacci: (1 a 100)\n");
        x = scanf("%d", &N);
        if (x != 1) {
            printf("Erro: entrada invalida\n");
            //limpar o buffer
            while (getchar() != '\n');
        }
        else if (N < 1 || N > 100) {
            printf("Erro: numero fora do intervalo\n");
        }
        else {
            break;//entrada válida
        }
        if (N >= 1 && N <= 100) {
            break;
        }
    }
    if (N == 1) {
        printf("%d",n1);
    } else {
        printf("%d, ",n1);
        printf("%d, ",n2);
    }

    if (N >= 3) {
        for (i = 2; i <= N; i++) {
            s = n1 + n2;
            printf("%d, ",s);
            n1 = n2;
            n2 = s;
        }
    }
    return 0;
}