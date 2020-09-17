#include <iostream>
#include <queue>
#include <algorithm>
int arr[101][101] = { 0 };
int col[101][101] = { 0 };
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
using namespace std;

int main() {
	int N, M, K, r, c, result = 0, t = 0;
	cin >> N >> M >> K;
	for (int i = 0; i < K; i++)
	{
		cin >> r >> c;
		arr[r][c] = 1;
	}
	queue<pair<int, int>>q;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			if (arr[i][j] == 1 && col[i][j] == 0)
			{
				q.push(make_pair(i, j));
				t++;
				col[i][j] = 1;
				while (!q.empty())
				{
					int x = q.front().first;
					int y = q.front().second;
					q.pop();
					for (int k = 0; k < 4; k++)
					{
						if (arr[x+dx[k]][y+dy[k]] == 1 && col[x + dx[k]][y + dy[k]] == 0)
						{
							q.push(make_pair(x+dx[k],y+dy[k]));
							t++;
							col[x + dx[k]][y + dy[k]] = 1;
						}
					}
				}
				result = max(result,t);
				t = 0;
			}
		}
	}
	cout << result;
}