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

void insertionSort(int a[], int n){
	for (int i = 0; i < n; i++){
		int key = a[i];
		int j = i -1;
		while (key < a[j] && j >= 0){
			a[j+1] = a[j];
			--j;
		}
		a[j+1] = key;
	}
}

int main(){
	int n;scanf("%d", &n);
	int a[n];
	init(a, n);
	insertionSort(a, n);
	out(a, n);
}