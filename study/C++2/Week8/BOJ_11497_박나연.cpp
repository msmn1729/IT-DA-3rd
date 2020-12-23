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
			scanf_s("%d", &L[j]); //baekjoon에서는 scanf로
		}
		int ans = 0;
		sort(L, L + N);
		/*번갈아 가면서 붙이기
		2,4,5,7,9
		2
		4,2
		4,2,5
		7,4,2,5
		7,4,2,5,9
		-> 인덱스 2차이 나는 것끼리 비교
		*/
		for (int k = 0; k < N - 2; k++) {
			int diff = L[k+2] - L[k];
			ans = max(ans, diff);
		}

		cout << ans << endl;

	}
}