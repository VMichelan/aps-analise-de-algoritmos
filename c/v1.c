#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int max_subarray(int v[], int size){
	int sum,best = INT_MIN;
	for(int i = 0;i < size;i++){
		for(int j = i;j < size;j++){
			sum = 0;
			for(int k = i; k <= j;k++){
				sum = sum + v[k];
			}
			if(sum > best)
				best = sum;
		}			
	}
	return best != INT_MIN ? best : 0;
}

int main(int argc,char *argv[]){
	int size = atoi(argv[1]);
	int v[size];
	int num;
	FILE* fp = fopen(argv[2],"r");
	int i;
	for(i = 0;i < size;i++){
		fscanf(fp,"%d",&num);
		v[i] = num;
	}
	clock_t start,end;
	int result;
	start = clock();
	result = max_subarray(v,size);
	end = clock();
	double duration = (double)(end - start)/CLOCKS_PER_SEC;
	if(argc > 3){
		if(strcmp(argv[3],"-t") == 0){
			printf("%lf\n",duration);
		}
		else if(strcmp(argv[3],"-r") == 0){
			printf("%d\n",result);
		}
	}
	return 0;
}

