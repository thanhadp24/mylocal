#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
};

struct Node* head;

Node* makeNode(int data){
	Node* newNode = (Node*)malloc(sizeof(struct Node));
	newNode->data = data;
	newNode->next = NULL;
	return newNode;
}

int size(){
	Node* tmp = head;
	int count = 0;
	while (tmp != NULL){
		count++;
		tmp = tmp->next;
	}
	return count;
}

void insertFirst(int data){
	Node* tmp = makeNode(data);
	if (head == NULL){
		head = tmp;
		return;
	}
	
	tmp->next = head;
	head = tmp;
}

void insertLast(int data){
	Node* tmp1 = makeNode(data);
	Node* tmp2 = head;
	if (head == NULL){
		insertFirst(data);
	}
	while (tmp2->next != NULL){
		tmp2 = tmp2->next;
	}
	tmp2->next = tmp1;
}

void insertMid(int data, int pos){
	Node* tmp1 = makeNode(data);
	Node* tmp2 = head;
	for (int i = 0; i < pos-2; i++){
		tmp2 = tmp2->next;
	}
	tmp1->next = tmp2->next;
	tmp2->next = tmp1;
}

void print(){
	Node* tmp = head;
	if (head == NULL){
		printf("the empty list");
	}
	while (tmp != NULL){
		printf("%d ", tmp->data);
		tmp = tmp->next;
	}
}

void reverse(){
	Node* current, *prev, *next;
	current = head;
	prev = NULL;
	while (current != NULL){
		next = current->next;
		current->next = prev;
		prev = current;
		current = next;
	}
	head = prev;
	
}

void deleteNode(int pos){
	Node* tmp = head;
	Node* tmp1;
	if (pos == 1) {
		tmp = head;
		head = head->next;
		free(tmp);
		return;
	}
	
	for (int i = 0; i < pos - 2; i++){
		tmp = tmp->next;
	}
	tmp1 = tmp->next;
	tmp->next = tmp1->next;
	free(tmp1);
}

int main(){
	head = NULL;
	insertFirst(12); // 12
	insertFirst(5);  // 5 12
	insertLast(6);   // 5 12 6
	insertMid(3, 2); // 5 3 12 6
	print();
	printf("\nsize ==> %d\n", size());
	reverse();      // 6 12 3 5
	deleteNode(2);
	print();
}