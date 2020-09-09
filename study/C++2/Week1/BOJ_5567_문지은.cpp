#include <iostream>
#include <vector>
#include <queue>
using namespace std;
vector <int> *map;
int visited[501] = { 0, };

int n, m;

int bfs()
{
	int num = 0;

	queue <int> q;

	for (int i = 0; i < map[1].size(); i++)
	{
		q.push(map[1][i]);
		visited[map[1][i]] = 1;
	}

	int c;
	while (!q.empty())
	{
		c = q.front();
		q.pop();

		for (int i = 0; i < map[c].size(); i++)
		{
			if (visited[map[c][i]] == 0 && map[c][i] != 1)
			{
				visited[map[c][i]] = 1;
			}
		}
	}
	
	for (int i = 1; i <= n; i++)
	{
		if (visited[i] == 1)
			num++;
	}
	
	return num;

}

int main()
{
	cin >> n >> m;
	
	map = new vector<int>[n + 1];

	for (int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		map[a].push_back(b);
		map[b].push_back(a);
	}

	cout << bfs();

}