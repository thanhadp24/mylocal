#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100

typedef struct Node {
    int key;
    struct Node* next;
    struct Node* previous;
} Node;

typedef struct {
    int capacity;
    Node* hashArray[MAX_SIZE];
} HashTable;

HashTable* createHashTable(int capacity) {
    if (capacity > MAX_SIZE) {
        printf("Hash size is too big\n");
        return NULL;
    }

    HashTable* H = (HashTable*)malloc(sizeof(HashTable));
    if (H == NULL) {
        printf("Out of space!!!\n");
        return NULL;
    }

    H->capacity = capacity;
    for (int i = 0; i < capacity; i++) {
        H->hashArray[i] = NULL;
    }

    return H;
}

void insertHashTable(int key, HashTable* H) {
    int hashKey = key % H->capacity;
    Node* node = (Node*)malloc(sizeof(Node));
    if (node == NULL) {
        printf("Out of space!!!\n");
        return;
    }

    node->key = key;
    node->next = H->hashArray[hashKey];
    node->previous = NULL;

    if (H->hashArray[hashKey] != NULL) {
        H->hashArray[hashKey]->previous = node;
    }

    H->hashArray[hashKey] = node;
}

Node* access(HashTable* H, int key) {
    int hashKey = key % H->capacity;
    Node* node = H->hashArray[hashKey];
    while (node != NULL) {
        if (node->key == key) {
            return node;
        }
        node = node->next;
    }
    return NULL;
}

void deleteHashTable(HashTable* H, int key) {
    int hashKey = key % H->capacity;
    Node* node = access(H, key);
    if (node != NULL) {
        if (node->previous != NULL) {
            node->previous->next = node->next;
        } else {
            H->hashArray[hashKey] = node->next;
        }

        if (node->next != NULL) {
            node->next->previous = node->previous;
        }

        free(node);
    }
}


void freeHashTable(HashTable* H) {
    if (H == NULL) {
        return;
    }

    for (int i = 0; i < H->capacity; i++) {
        Node* node = H->hashArray[i];
        while (node != NULL) {
            Node* temp = node;
            node = node->next;
            free(temp);
        }
    }

    free(H);
}

int main() {
    HashTable* H = createHashTable(10);

    insertHashTable(5, H);
    insertHashTable(28, H);
    insertHashTable(19, H);
    insertHashTable(15, H);
    insertHashTable(20, H);
    insertHashTable(33, H);
    insertHashTable(12, H);
    insertHashTable(17, H);
    insertHashTable(10, H);

    Node* x = access(H, 10);
    if (x != NULL) {
        printf("Found key %d in the hashtable\n", x->key);
    } else {
        printf("Key not found!!!\n");
    }

    printf("=============\n");

    deleteHashTable(H, 10);
    x = access(H, 10);
    if (x != NULL) {
        printf("Found key %d in the hashtable\n", x->key);
    } else {
        printf("Key not found!!!\n");
    }

    freeHashTable(H);

    return 0;
}
