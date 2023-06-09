#include <stdio.h>
#include <stdlib.h>

struct Edge {
	int a, b;
};

int M;
int N;
int T[100];

void makeSet(int T[], int N) {
	for (int i = 1; i <= N; i++) {
		T[i] = i;
	}
}

int findSet(int v) {
	if (T[v] == v) return v;
	else return findSet(T[v]);
}

void unionn(struct Edge e) {
	if (findSet(e.a) != findSet(e.b)) T[e.b] = e.a;
}

int main() {
	int i;
	N = M = 7;
	struct Edge E[7];
	E[0].a = 1; E[0].b = 2;
	E[1].a = 2; E[1].b = 3;
	E[2].a = 3; E[2].b = 4;
	E[3].a = 4; E[3].b = 1;
	E[4].a = 6; E[4].b = 5;
	E[5].a = 5; E[5].b = 7;
	E[6].a = 7; E[6].b = 6;

	makeSet(T, N);
	for (int i = 0; i < M; i++){
		unionn(E[i]);
	}
	
	int x = 3, y = 7;
	if (findSet(x) == findSet(y)){
		printf("%d and %d are connected ", x, y);
	}
	else printf("%d and %d are dis connected ", x, y);
}