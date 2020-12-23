#include<iostream>
using namespace std;

int main() {

	int N, M;
	cin >> N >> M;
	
	int A[1000003] = { 0, };

	for (int i = 0; i < N; i++) {
		cin >>  A[i];
	}

	long long left = 0;
	long long right = 100000000000000;
	//binary search
	while (left <= right) {
		long long mid = (left + right) / 2;
		long long count = 0;
		for (int i = 0; i < N; i++) {
			count += mid / A[i];
		}
		if (count >= M)
			right = mid-1;
		else
			left = mid+1;

	}
	cout << left;
	


}