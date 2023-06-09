#include <stdio.h>

void input(int a[], int n){
	for(int i = 0; i < n; i++){
		scanf("%d", &a[i]);
	}
}

void output(int a[], int n){
	for(int i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
}

void merge(int a[], int left, int mid, int right){
	int left_length = mid - left + 1;
	int right_length = right - mid;
	
	int a_left[left_length];
	int a_right[right_length];
	
	for(int i = 0; i < left_length; i++){
		a_left[i] = a[left + i];
	}
	
	for(int i = 0; i < right_length; i++){
		a_right[i] = a[mid + i + 1];
	}
	
	int i1 = 0;
	int i2 = 0;
	int k = left;
	
	while(i1 < left_length && i2 < right_length){
		if(a_left[i1] > a_right[i2]){
			a[k++] = a_right[i2];
			i2++;
		} else {
			a[k++] = a_left[i1];
			i1++;
		}
	}
	
	while(i1 < left_length){
		a[k++] = a_left[i1];
		i1++;
	}
	
	while(i2 < right_length){
		a[k++] = a_right[i2];
		i2++;
	}
	
}

void mergeSort(int a[], int left, int right){
	if(left >= right){
		return;
	}
	
	int mid = (left + right) / 2;
	mergeSort(a, left, mid);
	mergeSort(a, mid +1, right);
	merge(a, left, mid, right);
}
int main(){
	int n;
	scanf("%d", &n);
	int a[100];
	input(a, n);
	mergeSort(a, 0, n - 1);
	output(a, n);
	return 0;
}