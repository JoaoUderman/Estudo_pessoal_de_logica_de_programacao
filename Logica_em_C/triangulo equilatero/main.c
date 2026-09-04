#include <stdio.h>
#include <math.h>
#define Raiz3 1.73
# define espaco " "
int main(void) {
    int x,n = 1,max = 0,topo = 0;
    float base,h;
    printf("Valor da base: ");
    x = scanf("%f", &base);
    h = (Raiz3 / 2) * base;
    int hInt = (int)round(h);
    int baseInt = (int)round(base);
    topo = baseInt - 1;
    //topo = 40;
    for (int i = 0; i < hInt; i++) {
        n = 0;
        max++;
        topo--;
        //topo = topo - i -1;
        for (int t = 0; t < topo; t++) {
            printf(" ");
        }
        for (int j = 0; j < max; j++) {
           // if (n < 10) {
           //      printf("%d ", n);
           //  } else {
           //     printf("%d", n);
           //  }

            printf("0 ");

            // for (int z = 0; z < i; z++) {
            //     printf(espaco);
            // }
            n++;
        }
        printf("\n");
    }
    return 0;
}