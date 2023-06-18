#include<stdio.h>

void init(int a[],int n);
void out(int a[],int n);
int islast(int a[],int k,int n);
void gen(int a[],int n,int k);
void method_gen(int a[],int n,int k);
int d=0;

int main() {
	int n,k;
	printf("enter n,k(permutation nCk):");
	scanf("%d %d",&n,&k);
	int a[n];
	method_gen(a,n,k);
	return 0;
}

void init(int a[],int n) {
	for(int i=1; i<=n; i++) {
		a[i]=i;
	}
}
void out(int a[],int k) {
	printf("%d: ", ++d);
	for(int i=1; i<=k; i++) {
		printf("%d ", a[i]);
	} 
	printf("\n");
}
int islast(int a[],int k,int n) {
	for(int i=1; i<=k; i++) {
		if(a[i]!=n-k+i)
			return 0;
	}
	return 1;
}
void gen(int a[],int n,int k) {
	int i=k;
	while(a[i]==n-k+i) {
		i--;
	}
	a[i]+=1;
	for(int j=i+1; j<=k; j++) {
		a[j]=a[i]+j-i;
	}
}
void method_gen(int a[],int n,int k) {
	init(a,n);
	out(a,k);
	int stop=islast(a,k,n);
	while(stop==0) {
		gen(a,n,k);
		out(a,k);
		stop=islast(a,k,n);
	}
}