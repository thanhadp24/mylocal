#include <stdio.h>

void init(int a[], int n){
	for (int i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
}

void out(int a[], int n){
	for (int i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
}

void swap (int* a, int* b){
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

void selectionSort(int a[], int n){
	for (int i = 0; i < n-1; i++){
		int min_idx = i;
		for (int j = i +1 ; j < n; j++){
			if (a[min_idx] > a[j]) min_idx = j;
		}
		swap(&a[min_idx], &a[i]);
	}
}

int main(){
	int n;scanf("%d", &n);
	int a[n];
	init(a, n);
	selectionSort(a, n);
	out(a, n);
}