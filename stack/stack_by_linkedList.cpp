#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
};

Node* top;

void push(int data){
	Node* tmp = (Node*)malloc(sizeof(struct Node));
	tmp->data = data;
	tmp->next = top;
	top = tmp;
}

int pop(){
	Node* tmp = top;
	if (top == NULL){
		printf("underflow!");
		return -1;
	}
	int n = tmp->data;
	top = top->next;
	free(tmp);
	return n;
}

void display(){
	Node* tmp = top;
	while (tmp != NULL){
		printf("%d ", tmp->data);
		tmp = tmp->next;
	}
}

int main(){
	top = NULL;
	push(1);
	push(5);
	push(3); // 3 5 1
	int t = pop(); // 5 1
	display();
	printf("\npop value --> %d", t);
}