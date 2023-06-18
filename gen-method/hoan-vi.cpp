#include<stdio.h>

void init(int a[],int n);
void out(int a[],int n);
void gen(int a[],int n);
int islast(int a[],int n);
void method_gen(int a[],int n);
void swap(int *a,int *b);
int d=0;

int main() {
	int n;
	printf("enter n!: ");
	scanf("%d",&n);
	int a[n];
	method_gen(a,n);
	return 0;
}

void init(int a[],int n) {
	for(int i=1; i<=n; i++) {
		a[i]=i;
	}
}

void out(int a[],int n) {
	printf("%d:", ++d);
	for(int i=1; i<=n; i++) {
		printf("%d ",a[i]);
	}
	printf("\n");
}

int islast(int a[],int n) {
	for(int i=1; i<=n-1; i++) {
		if(a[i]<a[i+1]) return 0;
	}
	return 1;
}

void gen (int a[], int n) {
	int i = n-1;
	while (a[i] > a[i+1]) {
		i--;
	}

	int k = n;
	while (a[i] > a[k]) {
		k--;
	}

	swap(&a[k], &a[i]);
	int l = i+1;
	int r = n;
	while (l < r) {
		swap(&a[l], &a[r]);
		l++;
		r--;
	}
}

void method_gen(int a[],int n) {
	init(a,n);
	out(a,n);
	int stop=islast(a,n);
	while(stop==0) {
		gen(a,n);
		out(a,n);
		stop=islast(a,n);
	}
}

void swap(int *a,int *b) {
	int temp= *a;
	*a = *b;
	*b = temp;
}