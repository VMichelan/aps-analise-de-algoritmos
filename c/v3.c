#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int max(int a, int b) { return (a > b)? a : b; }

int maxCrossingSum(int arr[], int l, int m, int h){
    int sum = 0;
    int left_sum = INT_MIN;
    for (int i = m; i >= l; i--){
        sum = sum + arr[i];
        if (sum > left_sum)
          left_sum = sum;
    }
 
    sum = 0;
    int right_sum = INT_MIN;
    for (int i = m+1; i <= h; i++){
        sum = sum + arr[i];
        if (sum > right_sum)
          right_sum = sum;
    }
    return left_sum + right_sum;
}

int maxSubArraySum(int arr[], int l, int h){
   if (l == h)
     return arr[l];
   int m = (l + h)/2;
   return max(max(maxSubArraySum(arr, l, m),
              maxSubArraySum(arr, m+1, h)),
              maxCrossingSum(arr, l, m, h));
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
	result = maxSubArraySum(v,0,size-1);
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

