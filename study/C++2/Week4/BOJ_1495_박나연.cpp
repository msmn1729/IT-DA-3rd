#include<iostream>
#include<vector>
using namespace std;

int N, S, M;
int v[105];
int  dp[105][1005];
int result = 0;

int main() {

	cin >> N >> S >> M;
	for (int i = 1; i <= N; i++) {
		cin >> v[i];
	}

	dp[0][S] = 1;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j <= M; j++) {
			if (dp[i-1][j] == 1) {
				if (j - v[i] >= 0)
				{
					dp[i][j-v[i]] = 1;
				}
				if (j + v[i] <= M)
				{
					dp[i][j+v[i]] = 1;
				}

			}
		}
	}

	for (int i = 1; i <= M; i++) {
		if (dp[N][i])//max;
			result = i;
	}

	cout << result;



}