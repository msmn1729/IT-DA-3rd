#include <iostream>

using namespace std;

typedef struct Node
{   
    int data;
    Node* left;
    Node* right;
} Node;

Node* insert(Node* root, int data)
{
    if (root == nullptr) {
        root = new Node();
        root->data = data;
        root->left = nullptr;
        root->right = nullptr;
    }
    else if (data < root->data) {
        root->left = insert(root->left, data);
    }
    else if (data > root->data) {
        root->right = insert(root->right, data);
    }

    return root;
}

void print(Node* root)
{
    if (root->left != nullptr) {
        print(root->left);
    }
    if (root->right != nullptr) {
        print(root->right);
    }
    cout << root->data << endl;
}

int main(void)
{
    Node* root = nullptr;
    int data;

    while(scanf("%d", &data) != EOF) {
        root = insert(root, data);
    }
    // while (true) {
    //     cin >> data;
    //     if (data == 0) break;
    //     insert(root, data);
    // }
    // root = insert(root, 50);
    // root = insert(root, 30);
    // root = insert(root, 24);
    // root = insert(root, 5);
    // root = insert(root, 28);
    // root = insert(root, 45);
    // root = insert(root, 98);
    // root = insert(root, 52);
    // root = insert(root, 60);

    print(root);

    return 0;
}