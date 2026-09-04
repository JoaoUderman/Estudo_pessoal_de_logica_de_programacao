#include <stdio.h>

/* Faça um Programa que pergunte quanto você ganha por hora e o número
de horas trabalhadas no mês. Calcule e mostre o total do seu salário no
referido mês, sabendo-se que são descontados 11% para o Imposto de
Renda, 8% para o INSS e 5% para o sindicato, faça um programa que nos dê:
salário bruto. quanto pagou ao INSS. quanto pagou ao sindicato. o salário
líquido. calcule os descontos e o salário líquido, conforme a tabela abaixo:
Salário Bruto : R$
IR (11%) : R$
INSS (8%) : R$
Sindicato ( 5%) : R$
Salário Liquido : R$

Obs.: Salário Bruto - Descontos = Salário Líquido*/

/*perguntar valor por hora trabalhada = valorHoras
 * perguntar horas totais e guardar = horasTb
 *
 */
#define iR 0.89;
#define iNSS 0.92;
#define sindicato 0.95;
int main(void) {
    float horasT, valorHoras, tIR, tINSS, tSindicato, salarioB, salarioLiquido;
    int x,resp;
    while (1) {
        x = 0;
        horasT = 0;
        valorHoras = 0;
        resp = 0;
        while (x != 1 && valorHoras <= 0) {
            printf("Insira o valor da hora: ");
            x = scanf("%f", &valorHoras);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: Digite apenas números \n");
            } else if (valorHoras <= 0) {
                printf("Erro: Digite um valor válido");
            }
        }
        x = 0;
        while (x != 1 && horasT <= 0) {
            printf("Insira quantas horas: ");
            x = scanf("%f", &horasT);
            while (getchar() != '\n');
            if (x != 1) {
                printf("\nErro: Digite apenas números \n");
            } else if (valorHoras <= 0) {
                printf("\nErro: Digite um valor válido \n");
            }
        }
        salarioB = valorHoras * horasT;;
        tIR = salarioB * 0.11;
        tINSS = salarioB * 0.08;
        tSindicato = salarioB * 0.05;
        salarioLiquido = salarioB - tIR - tINSS - tSindicato;

        printf("\nSalário Bruto : R$%.2f\nIR (11%) : R$ %.2f\nINSS (8%) : R$ %.2f \nSindicato ( 5%) : R$ %2.f\nSalário Liquido : R$ %.2f",salarioB, tIR, tINSS, tSindicato, salarioLiquido);

        while (1) {
            printf("\n Deseja ir novamente? \n");
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