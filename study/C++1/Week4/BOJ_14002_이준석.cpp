#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<int>vec;
int main() {
	int N, result = 1, k=0;
	cin >> N;
	int arr[1001] = { 0 };
	int dp[1001] = { 0 };
	int arr2[1001] = { 0 };
	for (int i = 1; i <= N; i++)
	{
		cin >> arr[i];
		dp[i] = 1;
	}
	for (int i = 1; i <= N; i++)
	{
		for (int j = i - 1; j > 0; j--)
		{
			if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
				arr2[i] = j;
			}
		}
		if (result <= dp[i]) {
			result = dp[i];
			k = i;
		}
	}
	cout << result << endl;
	while (k > 0) {
		vec.push_back(arr[k]);
		k = arr2[k];
	}
	for (int i = vec.size()-1; i >= 0; i--)
		cout << vec[i] << ' ';
}
