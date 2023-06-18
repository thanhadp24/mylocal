#include <stdio.h>

void Try(int a[], int n, int i);
void out(int a[], int n);
int d = 0;

int main() {
	int n; scanf("%d", &n);
	int a[n+1];
	Try(a, n, 1);
}

void Try(int a[], int n, int i) {
	for (int j = 0; j <= 1; j++) {
		if (j == 0 || j == 1) {
			a[i] = j;
		}
		if (i == n) {
			out(a, n);
		} else Try(a, n, i+1);
	}
}

void out(int a[], int n) {
	printf("%d. ", ++d);
	for (int i = 1; i <= n; i++) {
		printf("%d ", a[i]);
	}
	printf("\n");
}


