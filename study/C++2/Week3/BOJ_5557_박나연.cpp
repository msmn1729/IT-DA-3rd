#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int N;
long long num[101];
long long dpArray[200][200];

int dp(int n, int res) {
	if (res < 0 || res > 20)
		return 0;
	if (n == N) {
	
		return dpArray[n][res];
	}
}

int main() {
	
	cin >> N;

	int n;
	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	cout << dp(2, num[1]) << endl;
}