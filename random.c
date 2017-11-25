#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int main(int argc, char *argv[]){
	srand(time(NULL));
	if(argc < 4)
		printf("Uso: ./a.out MIN MAX QTD ARQUIVO");
	int min = atoi(argv[1]);
	int max = atoi(argv[2]) + 1;
	int qtd = atoi(argv[3]);
	FILE* fp = fopen(argv[4],"w");
	printf("Min: %d\nMax:%d\nQuantidade: %d\nArquivo:%s",min,max,qtd,argv[4]);
	if(min < 0)
		min = min * -1;
	while (qtd > 0){
		fprintf(fp, "%d\n",(rand() % (max+min)) - min);
		qtd--;
	}
	fclose(fp);
	return 0;
}

