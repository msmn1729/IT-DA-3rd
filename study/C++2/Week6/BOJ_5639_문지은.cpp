#include <iostream>
using namespace std;

struct t
{
	int value = 0;
	t* left = 0;
	t* right = 0;
};

t *root;

void insert(t *node, int a)
{
	if (node == NULL)
		root->value = a;
	else
	{
		if (node->value < a)
			insert(node->right, a);
		else 
			insert(node->left, a);
	}
}

void print(t *node)
{
}

int main()
{
	int a;
	while (scanf("%d", &a) != NULL)
	{
		insert(root, a);
	}

	print(root);


}