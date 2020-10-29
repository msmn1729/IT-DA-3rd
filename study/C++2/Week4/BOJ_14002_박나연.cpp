#include<iostream>
#include<vector>
using namespace std;

int N;
int num[1005];
int length[1005];
int arr[1005];
int result = 0;
int m = 0;

void print(int ans) {
	if (ans == -1)
		return;
	print(arr[ans]);
	cout << num[ans] << ' ';

}

void dp(int n, int num[]) {

	for (int i = 1; i <= n; i++) {
		length[i] = 1;
		arr[i] = -1;
		for (int j = 1; j <= i; j++) {
			if (num[j] < num[i]) {
				if (length[i] < length[j] + 1) {
					length[i] = length[j] + 1;
					arr[i] = j;
				}
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		if (length[i] > result) {
			result = length[i];
			m = i;
		}
	}

	cout << result << endl;
	print(m);
	//
	
	

}


int main() {

	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> num[i];
	}
	dp(N, num);

}