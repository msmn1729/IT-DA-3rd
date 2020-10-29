#include <iostream>
#include <string.h>
using namespace std;


int main()
{
	int n, s, m;
	int v[101];
	int dp[101][1001];

	cin >> n >> s >> m;
	for (int i = 0; i < n; i++)
		cin >> v[i];

	for (int i = 0; i < 101; i++)
	{
		memset(dp[i], 0, sizeof(int) * 101);
	}

	if (s - v[0] >= 0) dp[0][s - v[0]] = 1;
	if (s + v[0] <= m) dp[0][s + v[0]] = 1;

	bool none;
	for (int i = 1; i < n; i++)
	{
		none = false;
		for (int j = 0; j <= m; j++)
		{
			if (dp[i - 1][j] == 1)
			{
				if (j + v[i] <= m)
				{
					dp[i][j + v[i]] = 1;
					none = true;
				}

				if (j - v[i] >= 0)
				{
					dp[i][j - v[i]] = 1;
					none = true;
				}
			}
		}
		if (!none)
		{
			cout << -1;
			return 0;
		}
	}
	int max = 0;
	for (int i = 0; i <= m; i++)
	{
		if (dp[n - 1][i] == 1 && max < i) max = i;
	}
	cout << max;

}