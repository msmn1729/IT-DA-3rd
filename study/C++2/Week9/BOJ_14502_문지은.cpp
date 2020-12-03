#include <iostream>
#include <algorithm>
using namespace std;
int map[10][10] = { 0, };
int tmap[10][10] = { 0, };
int visited[10][10] = { 0, };

int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };

int safe = 0;

int n, m;

int virus()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (map[i][j] == 2)
			{
				
			}
		}
	}
}

int dfs(int x, int y, int wall)
{
	visited[x][y] = 1;

	if (wall == 1)
	{
		int num = virus();
		safe = max(safe, num);
	}
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (visited[nx][ny] == 0 && map[nx][ny] == 0)
		{
			visited[nx][ny] = 1;
			dfs(nx, ny, wall - 1);
			visited[nx][ny] = 0;
		}

	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}
	
	int wall = 3;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			dfs(i, j, wall);
		}
	}

	cout << safe;
	
}