#include <stdio.h>
/* Dado qualquer número de 0 até 999, faça a decomposição dele nas casas de
unidades, dezenas e centenas. Exemplo:
372 = 300 + 70 + 2*/
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
        n1 = (n / 100) * 100;
        n = n % 100;
        if (n > 0) {
            printf("%d + ", n1);
        } else {
            printf("%d", n1);
        }
    }
    if (n > 9) {
        n1 = (n / 10) * 10;
        n = n % 10;
        if (n > 0) {
            printf("%d + ", n1);
        } else {
            printf("%d", n1);
        }
    }
    if (n >= 1) {
        printf("%d", n);
    }
    return 0;
}