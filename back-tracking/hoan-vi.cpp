#include<stdio.h>

void out(int a[], int n);
void Try(int a[], int used[], int n, int i);
int d=0;

int main() {
	int n;
	scanf("%d",&n);
	int a[n+1],used[n+1];
	for(int i=1; i<=n; i++) {
		used[i]=0;
	}
	Try(a,used,n,1);
	return 0;
}

void out(int a[], int n) {
	printf("%d: ",++d);
	for(int i=1; i<=n; i++) {
		printf("%d ",a[i]);
	}
	printf("\n");
}

void Try(int a[], int used[], int n, int i) {
	for (int j = 1; j <= n; j++) {
		if (used[j] == 0) {
			used[j] = 1;
			a[i] = j;
			if (i == n) out(a, n);
			else
				Try(a, used, n, i+1);
			used[j] = 0;
		}
	}
}

