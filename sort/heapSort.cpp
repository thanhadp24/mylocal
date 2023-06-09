#include <stdio.h>

void swap(int* a, int* b){
	int tmp = *a; 
	*a = *b;
	*b = tmp;
}

void heapify(int a[], int n, int i){
	int largest = i;
	int left = 2*i + 1;
	int right = 2*i + 2;
	if (left < n && a[left] > a[largest]){
		largest = left;
	}
	if (right < n && a[right] > a[largest]){
		largest = right;
	}
	if (largest != i){
		swap(&a[i], &a[largest]);
		heapify(a, n, largest);
	}
}

void heapSort(int a[], int n){
	// build max heap
	for (int i = n/2 -1; i>= 0; i--){
		heapify(a, n, i);
	}
	
	// heap sort
	for (int i = n-1; i >= 0; i--){
		swap(&a[0], &a[i]);
		heapify(a, i, 0);
	}
}

void display(int a[], int n){
	for (int i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

int main(){
	int n; scanf("%d", &n);
	int a[n];
	for (int i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
	heapSort(a, n);
	display(a, n);
	return 0;
}