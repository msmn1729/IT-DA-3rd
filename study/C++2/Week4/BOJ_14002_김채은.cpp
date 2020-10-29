#include <iostream>

using namespace std;

int N, arr[1001], dp[1001], len[1001], Max;

void Input() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
}
void Print(int idx) {
	if (idx == dp[idx]) {
		cout << arr[idx] << " ";
		return;
	}
	Print(dp[idx]);
	cout << arr[idx] << " ";
}

void Solution() {
	for (int i = 0; i < N; i++) {
		dp[i] = i, len[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				if (len[i] < len[j] + 1)
					len[i] = len[j] + 1, dp[i] = j;
			}
		}
		if (len[i] > len[Max])
			Max = i;
	}
}

int main() {
	Input();
	Solution();
	cout << len[Max] << "\n";
	Print(Max);
	return 0;
}

