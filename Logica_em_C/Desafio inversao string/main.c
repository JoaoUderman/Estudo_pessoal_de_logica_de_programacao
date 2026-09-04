#include <stdio.h>
#include <string.h>

int main(void) {
    char nome[100];
    int cont,x;
    printf("Digite o nome: ");
    scanf("%100[^\n]", nome);
    fflush(stdin);
    cont = strlen(nome);;
    char nomeC[cont-1];
    char inver[cont-1];
    strcpy(nomeC, nome);
    for (int i = 0; i < cont-1; i++) {
        for (int j = cont-1; j > 0; j--) {
            inver[i] = nomeC[j];
        }
    }
    printf("%s \n", inver);
    return 0;
}