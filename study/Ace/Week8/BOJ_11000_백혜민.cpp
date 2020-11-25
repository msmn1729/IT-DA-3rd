#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N; cin >> N;
	vector<pair<int, int>> v;
	for (int i = 0; i < N; i++)
	{
		int x, y; cin >> x >> y;
		v.push_back({ x,y });
	}
	sort(v.begin(), v.end());

	priority_queue<int,vector<int>,greater<int>> q;
	for (int i = 0; i < N; i++)
	{
		if (!q.empty() && v[i].first >= q.top())
			q.pop();

		q.push(v[i].second);
	}
	cout << q.size();

	return 0;
}
