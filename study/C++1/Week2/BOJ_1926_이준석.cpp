#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
int arr[502][502] = { 0 };
int col[502][502] = { 0 };
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int main() {
	int n, m, cnt = 0, tmp = 0, result = 0;
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			cin >> arr[i][j];
		}
	}
	queue<pair<int, int>>q;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			if (arr[i][j] == 1 && col[i][j] == 0)
			{
				q.push(make_pair(i, j));
				col[i][j] = 1;
				cnt++;
				result++;
				while (!q.empty())
				{
					int x = q.front().first;
					int y = q.front().second;
					q.pop();
					for (int k = 0; k <= 3; k++)
					{
						if (arr[x + dx[k]][y + dy[k]] == 1 && col[x + dx[k]][y + dy[k]] == 0)
						{
							q.push(make_pair(x+dx[k], y+dy[k]));
							col[x + dx[k]][y + dy[k]] = 1;
							cnt++;
						}
					}
				}
				tmp = max(cnt, tmp);
				cnt = 0;
			}
		}
	}
	cout << result << endl << tmp;
}