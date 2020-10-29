#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int a[1000];
	for (int i = 0; i < n; i++)
		cin >> a[i];
	
	//길이, 그 전 인덱스
	pair<int, int> dp[1000];

	for (int i = 0; i < n; i++)
	{
		dp[i].first = 1;
		dp[i].second = -1;

		for (int j = 0; j < i; j++)
		{
			if (a[j] < a[i] && dp[j].first + 1 > dp[i].first)
			{
				dp[i].first = dp[j].first + 1;
				dp[i].second = j;
			}
		}
	}

	cout << dp[n-1].first << endl;
	int ans[1000];
	int num = n-1;
	int aNum = 0;
	while (num != -1)
	{
		ans[aNum] = a[num];
		aNum++;
		num = dp[num].second;		
	}

	for (int i = aNum-1; i >= 0; i--)
	{
		cout << ans[i] << " ";
	}

}