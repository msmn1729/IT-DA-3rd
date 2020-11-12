#include <iostream>
#include <algorithm>
using namespace std;
int dp[1001][1001] = { 0 };
int arr[101] = { 0 };
int main() {
	int N, S, M, result=0;
	cin >> N >> S >> M;
	
	for (int i = 1; i <= N; i++)
		cin >> arr[i];
	dp[0][S] = 1;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 0; j <= M; j++)
		{
			if (dp[i-1][j] != 0)
			{
				if (arr[i] + j <= M)
				{
					dp[i][arr[i] + j] = 1;
				}
				if (j - arr[i] >= 0)
					dp[i][j-arr[i]] = 1;
			}
		}
	}
	int k = 0;
	for (int i = 0; i <= M; i++)
	{
		if (dp[N][i] != 0)
			result = max(result, i);
		else
			k++;
	}
	if (k == M+1)
		cout << -1;
	else
		cout << result;
	
}