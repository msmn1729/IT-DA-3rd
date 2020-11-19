#include<iostream>
#include<vector>
using namespace std;

int tree[100001];
int a[10000001];
int i = 0;

void binaryS(int left, int right) {


	if (left > right)
		return;
	
	int root = tree[left]; //전위 순회할때 루트
	int r = right; //전위 순회할때 오른쪽 부분에 차지 하는 거
	
	while (tree[r] > root) {
		r--;
	}
	binaryS(left + 1, r);
	binaryS(r + 1, right);
	cout << root << " ";

}



int main() {
	

	int put = 0;
	do{
		cin >> put;
		tree[i] = put;
		i++;
	} while (getc(stdin) == ' ');

	binaryS(0, i-1);

}