#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 2

struct Node {
	int data;
	struct Node* next;
};

struct Queue {
	struct Node* front;
	struct Node* rear;
	int capacity;
};

Queue* init() {
	Queue* q = (Queue*)malloc(sizeof(struct Queue));
	q->front = NULL;
	q->rear = NULL;
	q->capacity = 0;
	return q;
}

int isEmpty(Queue* q) {
	return q->rear == NULL;
}

int isFull(Queue* q){
	return q->capacity == MAX_SIZE;
}

void enqueue(Queue* q, int data) {
	Node* tmp = (Node*)malloc(sizeof(struct Node));
	tmp->data = data;
	tmp->next = NULL;
	if (isFull(q)) printf("queue overflow");
	if (!isEmpty(q)){
		q->rear->next = tmp;
		q->rear = tmp;
	} else {
		q->front = q->rear = tmp;
	}
	q->capacity++;
}

int dequeue(Queue* q) {
	Node* tmp = q->front;
	int n = q->front->data;
	if (q->front == NULL || q->front > q->rear) printf("queue underflow");
	else {
		q->front = q->front->next;
	}
	free (tmp);
	q->capacity--;
	return n;
}

void print(Queue* q) {
	Node* tmp = q->front;
	if (q->front == NULL) {
		printf("the empty");
		return;
	}

	while (tmp != NULL) {
		printf("%d ", tmp->data);
		tmp = tmp->next;
	}
}

int main() {
	Queue* q;
	q = init();
	enqueue(q,5);
	enqueue(q,7);
	enqueue(q,9);
	printf("%d\n", dequeue(q)); // 7 9
	print(q);
	printf("\nis empty --> %d ", isEmpty(q));
	printf("\nis full --> %d ", isFull(q));
	return 0;
}