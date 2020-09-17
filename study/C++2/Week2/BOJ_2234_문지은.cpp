#include <iostream>
#include <bitset>
#include <string>
#include <string.h>
using namespace std;
int map[51][51];
int visited[51][51] = { 0, };

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int n, m;
int maxS = 0;
int s;

void dfs(int x, int y)
{
	string str = bitset<4>(map[x][y]).to_string();

	int nx, ny;

	for (int i = 0; i < 4; i++)
	{
		nx = x + dx[i];
		ny = y + dy[i];

		if (str[i] == '0')
		{
			if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && visited[nx][ny] == 0)
			{
				s++;
				visited[nx][ny] = 1;
				dfs(nx, ny);

			}
		}

	}

	if (maxS < s) maxS = s;
}


int main()
{
	cin >> n >> m;

	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			cin >> map[i][j];
		}
	}

	int num = 0;
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			if (visited[i][j] == 0)
			{
				s = 1;
				num++;
				visited[i][j] = 1;
				dfs(i, j);

			}
		}
	}

	cout << num << endl;
	cout << maxS << endl;

	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			string str = bitset<4>(map[i][j]).to_string();
			if (str[0] == '1' && i != m)
			{
				s = 1;
				map[i][j] -= 8;
				for (int a = 1; a <= m; a++)
				{
					memset(visited[a], 0, sizeof(int) * (n+1));
				}
				visited[i][j] = 1;
				dfs(i, j);
				map[i][j] += 8;
			}
			if (str[1] == '1' && j != n)
			{
				s = 1;
				map[i][j] -= 4;
				for (int a = 1; a <= m; a++)
				{
					memset(visited[a], 0, sizeof(int) * n);
				}
				visited[i][j] = 1;
				dfs(i, j);
				map[i][j] += 4;
			}
			if (str[2] == '1' && i != 1)
			{
				s = 1;
				map[i][j] -= 2;
				for (int a = 1; a <= m; a++)
				{
					memset(visited[a], 0, sizeof(int) * n);
				}
				visited[i][j] = 1;
				dfs(i, j);
				map[i][j] += 2;
			}
			if (str[3] == '1' && j != 1)
			{
				s = 1;
				map[i][j] -= 1;
				for (int a = 1; a <= m; a++)
				{
					memset(visited[a], 0, sizeof(int) * n);
				}
				visited[i][j] = 1;
				dfs(i, j);
				map[i][j] += 1;
			}


		}
	}



	cout << maxS << endl;

}