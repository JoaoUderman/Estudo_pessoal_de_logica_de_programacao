#include <stdio.h>
/* 8. Faça o programa que apresenta a seguinte saída, perguntando ao usuário o
número máximo (no exemplo, 9). Este número deve ser sempre ímpar.
1 2 3 4 5 6 7 8 9
2 3 4 5 6 7 8
3 4 5 6 7
4 5 6
5 */
int main(void) {
    int max, x, n, resp, quant;
    while (1) {
        resp = 0;
        x = 0;
        max = 0;
        while (x != 1 || max <= 0 || (max % 2 == 0)) {
            printf("Digite o numero maximo: ");
            x = scanf("%d", &max);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: Digite apenas numeros! \n");
            } else if (max <= 0) {
                printf("\nErro: Digite numeros positivos! \n");
            } else if (max % 2 == 0) {
                printf("\nDigite apenas numeros impares! \n");
            }
        }
        //printf("\n %d \n",max);
        quant = max + 2;
        for (int i = 0; i < ((max + 1) / 2); i++) {
            quant = quant - 2;
            n = i + 1;
            for (int j = 0; j < quant; j++) {
                printf("%d ",n);
                n ++;
            }
            printf("\n");
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
                break;
            }
        }
    }
}