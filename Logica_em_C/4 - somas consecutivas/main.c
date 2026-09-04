#include <stdio.h>
/*4. Faça o algoritmo que dado dois números inteiros Num1 e Num2, calcule o produto
de Num1 * Num2, através de somas sucessivas, e depois imprima o resultado.*/

int main(void) {
    int n1, n2,s, x;
    while (1) {
        printf("Digite o numero 1: \n");
        x = scanf("%d", &n1);
        //verificação
        if (x != 1) {
            printf("Erro: entrada invalida\n");
            while (getchar() != '\n');
        }
        else if (n1 < 1) {
            printf("Digite um numero positivo");
        }
        else {
            break;
        }
    }
    while (1) {
        printf("Digite o numero 2: \n");
        x = scanf("%d", &n2);
        //verificação
        if (x != 1) {
            printf("Erro: entrada invalida\n");
            while (getchar() != '\n');
        }
        else if (n2 < 1) {
            printf("Digite um numero positivo");
        }
        else {
            break;
        }
    }
    s = n1;
    for (int i = 1; i < n2; i++) {
        printf("%d + %d = ", s, n1);
        s = s + n1;
        printf("%d\n", s);

    }
}