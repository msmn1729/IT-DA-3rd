#include <iostream>
#include <string>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string S, S1; cin >> S >> S1;
	int dp[1001][1001];
	string arr[1001][1001];

	for (int i = 0; i < 1001; i++)
	{
		for (int j = 0; j < 1001; j++)
		{
			dp[i][j] = 0; arr[i][j] = "";
		}
	}
	for (int i = 1; i <= S.length(); i++)
	{
		for (int j = 1; j <= S1.length(); j++)
		{
			if (S[i - 1] == S1[j - 1])
			{
				dp[i][j] = dp[i - 1][j - 1] + 1; arr[i][j] = arr[i - 1][j - 1] + S[i-1];
			}
			else
			{
				if (dp[i-1][j] > dp[i][j-1])
				{
					dp[i][j] = dp[i - 1][j]; arr[i][j] = arr[i - 1][j];
				}
				else
				{
					dp[i][j] = dp[i][j-1]; arr[i][j] = arr[i][j-1];
				}
			}
		}
	}
	cout << dp[S.length()][S1.length()] << "\n" << arr[S.length()][S1.length()];

	return 0;
}
