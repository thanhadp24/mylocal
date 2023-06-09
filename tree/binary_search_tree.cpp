#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct BstNode {
	int data;
	struct BstNode* left;
	struct BstNode* right;
	struct BstNode* parent;
};

struct BstNode* getNewNode(int data) {
	struct BstNode* newNode = (struct BstNode*)malloc(sizeof(struct BstNode));
	newNode->data = data;
	newNode->left = NULL;
	newNode->right = NULL;
	newNode->parent = NULL;
	return newNode;
}

struct BstNode* insert(struct BstNode* root, int data) {
	if (root == NULL) {
		return getNewNode(data);
	} else if (root->data >= data) {
		root->left = insert(root->left, data);
	} else {
		root->right = insert(root->right, data);
	}
	return root;
}

void preOrderTraversal(struct BstNode* root) {
	if (root == NULL) return;
	printf("%d ", root->data);
	preOrderTraversal(root->left);
	preOrderTraversal(root->right);
}

void inOrderTraversal(struct BstNode* root) {
	if (root == NULL) return;
	inOrderTraversal(root->left);
	printf("%d ", root->data);
	inOrderTraversal(root->right);
}

void postOrderTraversal(struct BstNode* root) {
	if (root == NULL) return;
	postOrderTraversal(root->left);
	postOrderTraversal(root->right);
	printf("%d ", root->data);
}

bool search(struct BstNode* root, int data) {
	if (root == NULL) return false;
	else if (root->data == data) return true;
	else if (root->data >= data) return search(root->left, data);
	else return search(root->right, data);
}

struct BstNode* minValue(struct BstNode* root) {
	struct BstNode* tmp = root;
	while (tmp && tmp->left != NULL) {
		tmp = tmp->left;
	}
	return tmp;
}

struct BstNode* deleteNode(struct BstNode* root, int data) {
	if (root == NULL) return root;
	else if (root->data > data) root->left = deleteNode(root->left, data);
	else if (root->data < data) root->right = deleteNode(root->right, data);
	else {
		// no child
		if (root->left == NULL && root->right == NULL) {
			free(root);
			root = NULL;
		}
		// have 1 child
		else if (root->left == NULL) {
			struct BstNode* tmp = root->right;
			free(root);
			root = tmp;
		} else if (root->right == NULL) {
			struct BstNode* tmp = root->left;
			free(root);
			root = tmp;
		}
		// 2 children
		else {
			struct BstNode* tmp = minValue(root->right);
			root->data = tmp->data;
			root->right = deleteNode(root->right, tmp->data);
		}
	}
	return root;
}

BstNode* inOrderSuccessor(BstNode* root, BstNode* n) {
	if (n->right != NULL) return minValue(n->right);
	BstNode* succ = NULL;
	while (root != NULL) {
		if (n->data < root->data) {
			succ = root;
			root = root->left;
		} else if (n->data > root->data){
			root = root->right;
		} else break;
	}
	return succ;
}

int main() {
	struct BstNode* root = getNewNode(5);
	root = insert(root, 4);
	root = insert(root, 6);
	root = insert(root, 42);
	root = insert(root, 3);
	root = insert(root, 2);
	root = insert(root, 33);

	printf("In-order traversal: ");
	inOrderTraversal(root);
	printf("\n============\n");

	printf("Pre-order traversal: ");
	preOrderTraversal(root);
	printf("\n============\n");

	printf("Post-order traversal: ");
	postOrderTraversal(root);
	printf("\n============\n");

	printf("Deleting node with value 42\n");
	root = deleteNode(root, 42);
	printf("\n============\n");

	printf("Pre-order traversal: ");
	preOrderTraversal(root);
	printf("\n============\n");
	BstNode *tmp, *succ;
//	tmp = root->left->left;
	succ = inOrderSuccessor(root, tmp);
	if (succ != NULL)
		printf("inorder successor of %d is %d ", tmp->data, succ->data);
	else printf("inorder succersor of %d is not exist!", tmp->data);
	printf("\n============\n");

	int number;
	printf("Enter a number to be searched: ");
	scanf("%d", &number);
	if (search(root, number))
		printf("Number found!\n");
	else
		printf("Number not found!\n");
	printf("============\n");

	return 0;
}
