#include <iostream>
#include <vector>
#include <string.h>
using namespace std;
long long dp[61][31][31] = { 0 }; // 일수, 현재 쓸 수 있는 W 개수, 여태까지 뽑은 W 개수 
vector<int>res;
int main() {
	int N;
	long long result = 0;
	while (1) {
		cin >> N;
		if (N == 0)
			break;
		dp[1][1][1] = 1;
		for (int i = 1; i <= 2 * N; i++)
		{
			for (int j = 0; j <= N; j++)
			{
				for (int k = 1; k <= N; k++)
				{
					if (dp[i][j][k] != 0)
					{
						if (i == 2 * N)
						{
							result += dp[i][j][k];
						}
						else {
							if (j > 0)
								dp[i + 1][j - 1][k] += dp[i][j][k];
							if (k < N)
								dp[i + 1][j + 1][k + 1] += dp[i][j][k];
						}
					}
				}
			}
		}
		res.push_back(result);
		result = 0;
		memset(dp, 0, sizeof(dp));
	}
	for (int i = 0; i < res.size(); i++)
		cout << res[i] << endl;
}