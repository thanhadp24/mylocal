#include<stdio.h>
#define MAX 20
void out(int x[],int n);
void Try(int i);
int d=0;

int x[MAX],a[MAX],b[MAX],c[MAX];
int n;

int main() {
	scanf("%d",&n);
	for(int i=1; i<=n; i++) {
		a[i]=1;
	}
	for(int i=2; i<=2*n; i++) {
		b[i]=1;
	}
	for(int i=1-n; i<=n-1; i++) {
		c[i]=1;
	}
	Try(1);
	return 0;
}

void out(int x[],int n) {
	printf("%d: ",++d);
	for(int i=1; i<=n; i++) {
		printf("%d ",x[i]);
	}
	printf("\n");
}

void Try(int i) {
	for(int j=1; j<=n; j++) {
		if(a[j]==1 && b[i+j]==1 && c[i-j]==1) {
			x[i]=j;
			a[j]=b[i+j]=c[i-j]=0;
			if(i==n) {
				out(x,n);
			} else Try(i+1);
			a[j]=b[i+j]=c[i-j]=1;
		}
	}

}
