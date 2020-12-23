#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N; cin >> N;
	vector<int> v;
	for (int i = 0; i < N; i++)
	{
		int x; cin >> x;
		v.push_back(x);
	}
	vector<pair<int, int>> answer;

	int low = 0, high = N - 1;
	int sum = abs(v[low]+v[high]);
	answer.push_back({ low,high });

	while (low < high)
	{
		if (sum > abs(v[low] + v[high]))
		{
			sum = abs(v[low] + v[high]);
			answer.front().first = low;
			answer.front().second = high;
		}

		if (v[low] + v[high] > 0)
			high--;
		else if (v[low] + v[high] < 0)
			low++;
		else
		{
			cout << v[low] << " " << v[high];
			return 0;
		}
	}
	cout << v[answer.front().first] << " " << v[answer.front().second];

	return 0;
}
