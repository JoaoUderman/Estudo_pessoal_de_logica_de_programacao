#include <stdio.h>
/*3. Faça a alteração no programa do desafio 2 para imprimir:
372 =  3 centenas, 7 dezenas, 2 unidades*/

int main(void) {
    int n, x, n1, n2;
    while (1) {
        printf("Digite um numero inteiro de 0 999\n");
        x = scanf("%d", &n);
        //verificação
        if (x != 1) {
            printf("Erro: entrada invalida\n");
            while (getchar() != '\n');
        }
        else if (n < 0 || n > 999) {
            printf("Erro: numero fora do intervalo\n");
        }
        else {
            break;
        }
    }
    if (n > 99) {
        n1 = (n / 100);
        n = n % 100;
        if (n > 0) {
            printf("%d centenas, ", n1);
        } else {
            printf("%d centenas", n1);
        }
    }
    if (n > 9) {
        n1 = (n / 10);
        n = n % 10;
        if (n > 0) {
            printf("%d dezenas, ", n1);
        } else {
            printf("%d dezenas", n1);
        }
    }
    if (n >= 1) {
        printf("%d unidades", n);
    }
    return 0;
}