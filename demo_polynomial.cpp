#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

struct ElementType{
    int c;  // coefficient
    int e;   // exponent
};

typedef struct ElementType X;

struct Node{
    X value;
    struct Node *next;
    struct Node *prev;
};  

typedef struct Node *Polynomial;
typedef struct Node *Position;

Position Last(Polynomial pL){
    Position nodeP;
    nodeP = pL;
    while(nodeP != NULL && nodeP->next != NULL){
        nodeP = nodeP->next;
    }
    return nodeP;
}

void insert(Polynomial *pL, X E){
    Position newItem;
    newItem = (struct Node*)malloc(sizeof(struct Node));
    newItem->value = E;
    newItem->prev = NULL;
    newItem->next = NULL;
    
    Position p = (*pL)->next;	
    
    while(p != NULL && p->value.e > E.e){
        p = p->next;
    }
    
    if(p != NULL){
        newItem->next = p;
        newItem->prev = p->prev;
        if(p->prev != NULL){
            p->prev->next = newItem;
        }
        p->prev = newItem;
    }
    else{
        Position last = Last(*pL);
        last->next = newItem;
        newItem->prev = last;
    }
}

void printPolynomial(Polynomial pL){
    Position p = pL->next;
    while(p != NULL){
        printf("%dx^%d ", p->value.c, p->value.e);
        p = p->next;
        if(p != NULL){
            printf("+ ");
        }
    }
    printf("\n");
}

void addPolynomials(Polynomial pA, Polynomial pB, Polynomial pC){
    Position pa = pA->next;
    Position pb = pB->next;
    
    while(pa != NULL && pb != NULL){
        if(pa->value.e == pb->value.e){
            X e;
            e.c = pa->value.c + pb->value.c;
            e.e = pa->value.e;
            insert(&pC, e);
            pa = pa->next;
            pb = pb->next;
        }
        else if(pa->value.e > pb->value.e){
            insert(&pC, pa->value);
            pa = pa->next;
        }
        else{
            insert(&pC, pb->value);
            pb = pb->next;
        }
    }
    
    while(pa != NULL){
        insert(&pC, pa->value);
        pa = pa->next;
    }
    
    while(pb != NULL){
        insert(&pC, pb->value);
        pb = pb->next;
    }
}
void multiplyPolynomials(Polynomial pA, Polynomial pB, Polynomial pD){
    Position pa = pA->next;
    Position pb = pB->next;
    
    while(pa != NULL){
        while(pb != NULL){
            X e;
            e.c = pa->value.c * pb->value.c;
            e.e = pa->value.e + pb->value.e;
            insert(&pD, e);
            pb = pb->next;
        }
        pa = pa->next;
        pb = pB->next;
    }
}

int main(){
    Polynomial A = NULL, B = NULL, C = NULL, D = NULL;
    Position hA, hB, hC, hD;
    
    hA = (struct Node*)malloc(sizeof(struct Node));    
    hB = (struct Node*)malloc(sizeof(struct Node));    
    hC = (struct Node*)malloc(sizeof(struct Node));    
    hD = (struct Node*)malloc(sizeof(struct Node));    
    
    hA->value.e = INT_MAX;
    hB->value.e = INT_MAX;
    hC->value.e = INT_MAX;
    hD->value.e = INT_MAX;
    
    hA->prev = NULL;
    hA->next = NULL;
    
    hB->prev = NULL;
    hB->next = NULL;
    
    hC->prev=NULL;
    hC->next=NULL;
    hD->prev = NULL;
	hD->next = NULL;
	
	A = hA;
	B = hB;
	C = hC;
	D = hD;
	
	X e1, e2, e3, e4, e5;
	e1.c = 3; e1.e = 6;
	e2.c = 2; e2.e = 3;
	e3.c = 5; e3.e = 2;

	
	insert(&A, e1);
	insert(&A, e2);
	insert(&A, e3);

	
	e1.c = 5; e1.e = 10;
	e2.c = 3; e2.e = 6;
	e3.c = 2; e3.e = 4;

	
	insert(&B, e1);
	insert(&B, e2);
	insert(&B, e3);
	
	
	printf("Polynomial A: ");
	printPolynomial(A);
	
	printf("Polynomial B: ");
	printPolynomial(B);
		
	addPolynomials(A, B, C);
	printf("\nPolynomial C: ");
	printPolynomial(C);
	
	multiplyPolynomials(A,B,D);
	printf("\nPolynomial D: ");
	printPolynomial(D);
	return 0;
}
