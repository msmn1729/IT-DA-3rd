#include <iostream>
#include <vector>
#include <string>
#include <math.h>
#include <queue>
#include <cstring>
using namespace std;
int visited[105];
vector <pair<int, int>> v;
vector <string> ans;

int t;
int n;

void bfs(int start)
{
	queue <int> q;

	q.push(start);
	visited[start] = 1;
	
	while (!q.empty())
	{
		int now = q.front();
		q.pop();

		if (now == n+1)
		{
			ans.push_back("happy");
			return;
		}

		for (int j = 0; j < n+2; j++)
		{
			if (visited[j] == 0 && (abs(v[now].first - v[j].first) + abs(v[now].second - v[j].second)) <= 1000)
			{
				visited[j] = 1;
				q.push(j);
			}
		}

	}
	ans.push_back("sad");
	
}

int main()
{
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		cin >> n;
		
		memset(visited, 0, sizeof(int) * 105);
		v.clear();

		for (int j = 0; j < n+2; j++)
		{
			int x, y;
			cin >> x >> y;
			v.push_back(make_pair(x, y));

		}

		bfs(0);
	}

	for (int i = 0; i < t; i++)
	{
		cout << ans[i] << endl;
	}
}