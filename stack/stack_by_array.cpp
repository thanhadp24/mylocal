#include <stdio.h>

#define MAX_SIZE 10

int a[MAX_SIZE];
int top = -1;

void push(int data) {
	if (top == MAX_SIZE -1) {
		printf("overflow!");
		return;
	}

	a[++top] = data;
}

int pop() {
	if (top == -1) {
		printf("underflow!");
		return -1;
	}

	int n = a[top];
	top--;
	return n;
}

void display(){
	for (int i = 0; i <= top; i++){
		printf("%d ", a[i]);
	}
}

int main(){
	push(5);
	push(6);
	push(9);
	int tmp = pop(); // 5 6
	display();
	printf("\npop value --> %d", tmp);
	
}