#include <iostream>
#include <algorithm>
using namespace std;
int N,M;

int BS(int b[], int start, int end, int V) {
	int mid;
	while (end >= start) {
		mid = (start + end) / 2;
		if (b[mid] >= V) {
			end = mid - 1;
		}
		else {
			start = mid+1;
		}
	}
	if ((mid == 0) && (b[mid] >= V)) { return mid; }
	return mid + 1;
}
int main()
{
	int T;
	cin >> T;
	while (T) {
		int cnt = 0;
		cin >> N >> M;
		int A, B;
		int a[20001];
		int b[20001];
		for (int i = 0; i < N;i++) {
			cin >> A;
			a[i] = A;
		}

		for (int i = 0; i < M; i++) {
			cin >> B;
			b[i] = B;
		}
		sort(b, b + M);
		for (int i = 0; i < N;i++) {
			cnt += BS(b, 0, M - 1, a[i]);
		}
		cout << cnt<<"\n";
		T--;
	}
}


