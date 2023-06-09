#include <stdio.h>

void input(int a[], int n){
	for(int i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
}

void out(int a[], int n){
	for(int i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
}


void swap(int *a, int *b){
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

void quickSort(int a[], int left , int right){
	if (left >= right) return;
	int i =left;
	int j = right;
	int pivot = a[(left + right)/2];
	while (a[i] < pivot) i++;
	while (a[j] > pivot) j--;
	if (i <= j){
		swap(&a[i], &a[j]);
		i++;
		j--;
	}
	
	quickSort(a, left, j);
	quickSort(a, i, right);
}

int main(){
	int n;scanf("%d", &n);
	int a[100];
	input(a, n);
	
	quickSort(a, 0, n - 1);
	out(a, n);
	return 0;
}