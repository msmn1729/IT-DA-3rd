#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string S, S1, S2; cin >> S >> S1 >> S2;
	int dp[101][101][101];

	for (int i = 0; i <=S.length(); i++)
	{
		for (int j = 0; j <=S1.length(); j++)
		{
			for(int k=0;k<=S2.length();k++)
				dp[i][j][k] = 0;
		}
	}
	for (int i = 1; i <= S.length(); i++)
	{
		for (int j = 1; j <= S1.length(); j++)
		{
			for (int k = 1; k <= S2.length(); k++)
			{
				if (S[i - 1] == S1[j - 1] && S1[j - 1] == S2[k - 1])
					dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
				else
				{
					dp[i][j][k] = max(dp[i - 1][j][k], max(dp[i][j - 1][k], dp[i][j][k - 1]));
					dp[i][j][k] = max(dp[i][j][k], max(dp[i - 1][j - 1][k], max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1])));
				}
			}
		}
	}
	cout << dp[S.length()][S1.length()][S2.length()];

	return 0;
}
