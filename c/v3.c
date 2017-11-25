#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int max_subarray(int v[], int lo,int hi){
	if (lo >= hi)
		return v[lo];
	int mid = (lo+hi)/2;
	int leftMax = max_subarray(v,lo,mid);
	int rightMax = max_subarray(v,mid+1,hi);
	int leftBothMax = INT_MIN,leftBothSum = 0;
	for(int i = mid; i >= 0;i--){
		leftBothSum += v[i];
		if (leftBothSum > leftBothMax)
			leftBothMax = leftBothSum;
	}
	int rightBothMax = INT_MIN,rightBothSum = 0;
	for(int i = mid+1; i <= hi;i++){
		rightBothSum += v[i];
		if (rightBothSum > rightBothMax)
			rightBothMax = rightBothSum;
	}

	int bothMax = leftBothMax + rightBothMax;

	if(bothMax > leftMax && bothMax > rightMax)
		return bothMax;
	else if (leftMax > bothMax && leftMax > rightMax)
		return leftMax;
	else
		return rightMax;

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
	result = max_subarray(v,0,size-1);
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

