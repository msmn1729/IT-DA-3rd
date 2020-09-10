#include <iostream>
#include <queue>
using namespace std;
int map[101][101] = { 0, };
int visited[101][101] = { 0, };

int n, m, k;

int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

int bfs(int sx, int sy)
{
	queue <pair<int, int>> q;

	int num = 1;
	
	q.push(make_pair(sx, sy));
	visited[sx][sy] = 1;

	while (!q.empty())
	{
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx >= 1 && nx <= n && ny >= 1 && ny <= m)
			{
				if (visited[nx][ny] == 0 && map[nx][ny] == 1)
				{
					visited[nx][ny] = 1;
					num++;
					q.push(make_pair(nx, ny));
				}
			}
		}
	}

	return num;
}

int main()
{
	cin >> n >> m >> k;

	for (int i = 0; i < k; i++)
	{
		int x, y;
		cin >> x >> y;
		map[x][y] = 1;
	}

	int ans = 0;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1;  j <= m;  j++)
		{
			if (map[i][j] == 1)
			{
				int n = bfs(i, j);
				if (n > ans) ans = n;
			}
		}
	}

	cout << ans;

	
}