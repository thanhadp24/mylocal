#include<stdio.h>

/*
	x1 + x2 + x3... = k, x1 >= 0; x2 >= 0; x3 >= 0; ...
	==> Find the sum of positive integer solutions.
*/
void out(int a[],int n);
void Try(int a[],int n,int k,int i);
int d=0;

int main() {
	int n,k;
	printf("enter n,k (n<k):");
	scanf("%d %d",&n,&k);
	int a[n+1];
	Try(a,n,k,1);
	return 0;
}

void out(int a[],int n) {
	printf("%d: ",++d);
	for(int i=1; i<=n; i++) {
		printf("%d ",a[i]);
	}
	printf("\n");
}
void Try(int a[],int n,int k,int i) {
	for(int j=0; j<=k; j++) {
		a[i]=j;
		if(i==n) {
			if(a[i]==k) {
				out(a,n);
			}
		} else Try(a,n,k-a[i],i+1);
	}
}