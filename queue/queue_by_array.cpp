#include <stdio.h>

#define MAX_SIZE 10

int queue[MAX_SIZE];
int size = -1;
int front = -1;
int rear = -1;

int isEmpty(){
	return size < 0;
}

int isFull(){
	return size == MAX_SIZE;
}

void enqueue(int data) {
	if (size < MAX_SIZE) {
		if (size < 0) {
			queue[0] = data;
			front = rear = 0;
			size = 1;
		} else if (rear == MAX_SIZE - 1) {
			queue[0] = data;
			rear = 0;
			size++;
		} else {
			queue[rear+1] = data;
			rear++;
			size++;
		}
	} else printf("queue overflow");
}

int dequeue() {
	int n = queue[front];
	if (isEmpty()) {
		printf("queue underflow!");
		return 0;
	} else {
		size--;
		front++;
	}
	return n;
}

void print(){
	if (isEmpty()) printf("the empty queue");
	int i = front;
	int count = size;
	while (count > 0){
		printf("%d ", queue[i]);
		i = (i+1) % MAX_SIZE;
		count--;
	}
	printf("\n");
}

int main() {
	
    enqueue(4);
    enqueue(8);
    enqueue(10);
    enqueue(20); // 4 8 10 20
    print();
    dequeue(); // 8 10 20
    printf("After dequeue\n");
    print();
    enqueue(50);
    enqueue(60);
    enqueue(70);
    enqueue(80); // 8 10 20 50 60 70 80
    dequeue();   // 10 20 50 60 70 80
    enqueue(90);
    enqueue(100);
    enqueue(110);
    enqueue(120); // 10 20 50 60 70 80 90 100 110 120
    printf("After enqueue\n");
    print();
    return 0;
}