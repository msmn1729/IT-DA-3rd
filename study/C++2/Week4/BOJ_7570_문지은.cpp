#include <iostream>
#include <vector>
using namespace std;

int n;
int arr[1000000];
//길이, 전 인덱스
pair<int, int> dp[1000000];

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++)
	{
		dp[i].first = 1;
		dp[i].second = -1;
		for (int j = 0; j < i; j++)
		{
			if (arr[i] == arr[j] + 1 && dp[j].first + 1 > dp[i].first)
			{
				dp[i].first = dp[j].first + 1;
				dp[i].second = j;
			}
		}
	}

	cout << n - dp[n - 1].first;
}
