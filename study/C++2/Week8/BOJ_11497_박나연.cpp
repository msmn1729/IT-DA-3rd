#include<iostream>
#include<stdio.h>
#include<algorithm>
using namespace std;


int main() {

	int T, N;
	int *L = new int[1000001];
	
	

	cin >> T;
	

	for (int i = 0; i < T; i++)
	{
		cin >> N;
		for (int j = 0; j < N; j++) {	
			scanf_s("%d", &L[j]); //baekjoon������ scanf��
		}
		int ans = 0;
		sort(L, L + N);
		/*������ ���鼭 ���̱�
		2,4,5,7,9
		2
		4,2
		4,2,5
		7,4,2,5
		7,4,2,5,9
		-> �ε��� 2���� ���� �ͳ��� ��
		*/
		for (int k = 0; k < N - 2; k++) {
			int diff = L[k+2] - L[k];
			ans = max(ans, diff);
		}

		cout << ans << endl;

	}
}