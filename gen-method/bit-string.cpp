#include <stdio.h>

void init(int a[],int n);
void out(int a[],int n);
int islast(int a[],int n);
void gen(int a[],int n);
void gen_method(int a[],int n);
int d=0;

int main(){
	int n; scanf("%d", &n);
	int a[n+1];
	gen_method(a, n);
	return 0;
}

void init (int a[], int n){
	for (int i = 1; i <= n; i++){
		a[i] = 0;
	}
}

void out (int a[], int n){
	printf("%d: ", ++d);
	for (int i = 1; i <= n; i++){
		printf("%d ", a[i]);
	}		
	printf("\n");
}

int isLast (int a[], int n){
	for (int i = 1; i <= n; i++){
		if (a[i] == 0) return 0;
	}
	return 1;
}

void gen (int a[], int n){
	int i = n;
	while (a[i] == 1){
		i--;
	}
	a[i] = 1;
	for (int j = i+1; j <= n; j++){
		a[j] = 0;
	}
}

void gen_method (int a[], int n){
	init(a, n);
	out(a, n);
	int stop = isLast(a, n);
	while (stop == 0){
		gen(a, n);
		out(a, n);
		stop = isLast(a, n);
	}
}