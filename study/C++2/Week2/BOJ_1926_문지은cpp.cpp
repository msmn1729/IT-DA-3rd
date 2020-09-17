#include <iostream>
using namespace std;
int n, m;
int map[501][501];
int visited[501][501] = { 0, };

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

int pSize;
int maxSize;

void dfs(int x, int y)
{
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && visited[nx][ny] == 0 && map[nx][ny] == 1)
		{
			visited[nx][ny] = 1;
			dfs(nx, ny);
			pSize++;
		}
	}

	if (maxSize < pSize) maxSize = pSize;
	
}

int main()
{
	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			cin >> map[i][j];
		}
	}

	int num = 0;
	int max = 0;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			if (map[i][j] == 1 && visited[i][j] == 0)
			{
				pSize = 1;
				visited[i][j] = 1;
				num++;
				dfs(i, j);
			}
		}
	}	

	cout << num << endl;
	cout << maxSize << endl;
}