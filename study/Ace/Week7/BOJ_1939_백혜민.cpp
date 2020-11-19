#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<pair<int,int>> v[100010];
bool visited[100010];
bool dfs(int x, int y, int m) //start,end point, weight
{
	if (x == y) //주어진 weight가 다리에 도착 가능
		return true;

	for (int k = 0; k < v[x].size(); k++)
	{
		if (!visited[v[x][k].first] && v[x][k].second >= m)
		{
			visited[v[x][k].first] = true;
			if (dfs(v[x][k].first, y, m))
				return true;
		}
	}

	return false;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<int> w;
	int N, M; cin >> N >> M;
	for (int i = 0; i < M; i++)
	{
		int A, B, C;
		cin >> A >> B >> C;

		v[A].push_back({ B,C });
		v[B].push_back({ A,C });
		w.push_back(C);
	}

	sort(w.begin(), w.end());
	int s, e; cin >> s >> e;

	int low = 0, high = M - 1; //인덱스를 이분탐색 기준으로 둔다
	int answer = -1;
	visited[s] = true;
	while (low <= high)
	{
		for (int i = 1; i <= M; i++)
			visited[i] = false;
		int mid = (low + high) / 2;
		if (dfs(s, e, w[mid]))
		{
			answer = w[mid];
			low = mid + 1;
		}
		else
			high = mid - 1;
	}
	cout << answer;

	return 0;
}
