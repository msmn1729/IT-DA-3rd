#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[1500000] = { 0, };

int main()
{
	int n;
	cin >> n;

	int d, m;
	cin >> d >> m;

	dp[d - 1] = m;

	int ans = 0;
	int i;
	for (i = 1; i < n; i++)
	{
		cin >> d >> m;
		ans = max(ans, dp[i - 1]);
		dp[d + i - 1] = max(ans + m, dp[d + i - 1]);
	}
	ans = max(ans, dp[i - 1]);


	cout << ans;

}