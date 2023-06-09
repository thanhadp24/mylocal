#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
	struct Node* prev;
};

struct Node* head;

Node* makeNode(int data) {
	Node* newNode = (Node*)malloc(sizeof(struct Node));
	newNode->data = data;
	newNode->next = NULL;
	newNode->prev = NULL;
	return newNode;
}

void insertFirst(int data) {
	Node* tmp = makeNode(data);
	if (head == NULL) {
		head = tmp;
		return;
	}
	tmp->next = head;
	head->prev = tmp;
	head = tmp;
}

void insertLast(int data) {
	Node* tmp = makeNode(data);
	Node* tmp1 = head;
	while (tmp1->next != NULL) {
		tmp1 = tmp1->next;
	}
	tmp1->next = tmp;
	tmp->prev = tmp1;
}

void insertMid(int data, int pos) {
	Node* tmp = makeNode(data);
	Node* tmp1 = head;
	if (pos == 1) {
		insertFirst(data);
		return;
	}
	for (int i = 0; i < pos - 2; i++) {
		tmp1 = tmp1->next;
	}
	Node* tmp2 = tmp1;
	tmp->next = tmp1->next;
	tmp1->next->prev = tmp;
	tmp2->next = tmp;
	tmp->prev = tmp2;
}

void reverse() {
	Node* tmp = head;
	if (tmp == NULL) return;
	while (tmp->next != NULL) {
		tmp = tmp->next;
	}
	printf("reverse --> ");
	while (tmp != NULL) {
		printf("%d ", tmp->data);
		tmp = tmp->prev;
	}
}

void deleteNode(int pos) {
	Node* tmp = head;
	if (pos == 1) {
		head = head->next;
		free(tmp);
		tmp = NULL;
		head->prev = NULL;
		return;
	}

	for (int i = 0; i < pos - 2; i++) {
		tmp = tmp->next;
	}
	Node* tmp1 = tmp->next;
	tmp1->next->prev = tmp;
	tmp->next = tmp1->next;
	free(tmp1);
}

void print() {
	Node* tmp = head;
	if (head == NULL) printf("the empty list");
	while (tmp != NULL) {
		printf("%d ", tmp->data);
		tmp = tmp->next;
	}
	printf("\n");
}

int main() {
	head = NULL;
	insertFirst(3);
	insertFirst(5);
	insertFirst(7);
	insertLast(9);   // 7 5 3 9
	insertMid(11, 3); // 7 5 11 3 9
	deleteNode(1); // 7 11 3 9
	print();
	reverse();
	return 0;
}