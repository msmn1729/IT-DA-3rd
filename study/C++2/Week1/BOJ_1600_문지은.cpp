#include <iostream>
#include <queue>
#include <string.h>
using namespace std;
int map[201][201] = { 0, };
int visited[201][201] = { 0, };

int k, w, h;
int x, y;

int dx1[8] = { -1, -2, -2, -1, 1, 2, 2, 1 };
int dy1[8] = { -2, -1, 1, 2, -2, -1, 1, 2 };

int dx2[4] = { 1, -1, 0, 0 };
int dy2[4] = { 0, 0, 1, -1 };

queue<pair<int, pair<int, int>>> q;
queue<pair<int, pair<int, int>>> q2;

int bfs1()
{
	q.push(make_pair(0, make_pair(1, 1)));

	while (!q.empty())
	{
		x = q.front().second.first;
		y = q.front().second.second;
		int move = q.front().first;

		if (x == w && y == h)
			return move;

		if (move == k)
			return -1;

		q.pop();

		for (int i = 0; i < 8; i++)
		{
			int nx = x + dx1[i];
			int ny = y + dy1[i];

			if (visited[nx][ny] == 0 && nx >= 1 && nx <= w && ny >= 1 && ny <= h)
			{
				visited[nx][ny] = 1;
				q.push(make_pair(move+1, make_pair(nx, ny)));
			}
		}

	}

}

int bfs2(int cx, int cy)
{
	for (int i = 1; i <= h; i++)
	{
		memset(visited[i], 0, sizeof(int)*(w+1));
	}

	q2.push(make_pair(k, make_pair(cx, cy)));
	visited[cx][cy] = 1;

	while (!q2.empty())
	{
		x = q2.front().second.first;
		y = q2.front().second.second;
		int move = q2.front().first;
		q2.pop();

		if (x == w && y == h)
			return move;

		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx2[i];
			int ny = y + dy2[i];

			if (visited[nx][ny] == 0 && nx >= 1 && nx <= w && ny >= 1 && ny <= h && map[nx][ny] == 0)
			{
				visited[nx][ny] = 1;
				q2.push(make_pair(move+1, make_pair(nx, ny)));
			}
		}
	}
	return 99999999;
}

int main()
{
	cin >> k >> w >> h;

	for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++)
		{
			cin >> map[i][j];
		}
	}
	visited[1][1] = 1;
	int num = 99999999;
	
	int a1, a2;
	a1 = bfs1();
	if (a1 == -1)		//k번 넘어서 도착
	{
		int t = q.size();
		for (int i = 0; i < t; i++)
		{
			a2 = bfs2(q.front().second.first, q.front().second.second);
			q.pop();
			if (num > a2) num = a2;
		}
		if (a2 == 99999999) cout << -1 << endl;
		else cout << num << endl;
	}
	else
		cout << bfs1() << endl;		//k번 안에 도착
	
}