#include <stdio.h>
#include <locale.h>
/*9. Faça a divisão por subtrações sucessivas, imprimindo o resto e o
quociente, entre dois números inteiro, informados pelo usuário. Caso o
divisor seja menor que o dividendo.*/

int main(void) {
    setlocale(LC_ALL, "Portuguese");
    int dividendo, divisor, quociente = 0, x, resto, resp, total;
    while (1) {
        total = 0;
        quociente = 0;
        x = 0;
        do {
            printf("Digite o valor do dividendo: \n");
            x = scanf("%d", &dividendo);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: digite apenas numeros \n");
            } else if (dividendo <= 0) {
                printf("\nErro: divisor nao positivo \n");
            }
        } while (x != 1 || dividendo <= 0);
        x = 0;
        do {
            printf("Digite o valor do divisor: \n");
            x = scanf("%d", &divisor);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: digite apenas números \n");
            } else if (divisor <= 0) {
                printf("\nErro: divisor nao positivo \n");
            } else if (dividendo < divisor) {
                printf("\nErro: dividendo menor que divisor \n");
            }
        } while (x != 1 || divisor <= 0 || divisor > dividendo);

        //resto = dividendo % divisor;

        // for (int i = 0; total != divisor) {
        //     total = dividendo - divisor;
        //     printf("%d - %d = %d\n",dividendo, divisor, total);
        //     dividendo = dividendo - divisor;
        //     if (total == divisor) {
        //         i = dividendo;
        //     }
        //     quociente++;
        // }
        // quociente ++;


        // while (total != divisor && dividendo > divisor) {
        //     quociente++;
        //     total = dividendo - divisor;
        //     printf("%d - %d = %d\n",dividendo, divisor, total);
        //     dividendo = dividendo - divisor;
        // }
        // if ( dividendo % divisor == 0) {
        //     quociente++;
        // }

       do {
            total = dividendo - divisor;
            printf("%d - %d = %d\n",dividendo, divisor, total);
            dividendo -= divisor;
            quociente ++;
            if (total == 0) {
                resto = total;
                break;
            } else if (total < divisor) {
                resto = total;
                break;
            }
       } while (total != 0 || total > divisor);
        //while mal formulado, mas funciona devido ao break.

        printf("------------------------------------");
        printf("\n Resto: %d\n Quociente: %d \n", resto, quociente);

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