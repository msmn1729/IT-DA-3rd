#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int limit[3] = { 0, };
int bottle[3] = { 0, };
int visited[201][201][201] = { 0, };

vector <int> v;

void dfs(int a, int b, int c);

void give(int from, int to)
{
	if (bottle[from] == 0) return;

	if (bottle[from] + bottle[to] > limit[to] && bottle[from] - (limit[to] - bottle[to]) >= 0)
	{
		bottle[from] = bottle[from] - (limit[to] - bottle[to]);
		bottle[to] = limit[to];
	}
	else if (bottle[from] + bottle[to] <= limit[to] && bottle[from] - bottle[to] >= 0)
	{
		bottle[to] += bottle[from];
		bottle[from] = 0;
	}
}

void dfs(int a, int b, int c)
{
	if (bottle[0] == 0 && bottle[1] != 0)
	{
		v.push_back(bottle[2]);
		return;
	}

	int na, nb, nc;

	bottle[0] = a;
	bottle[1] = b;
	bottle[2] = c;
	give(0, 1);
	na = bottle[0];
	nb = bottle[1];
	nc = bottle[2];

	if (visited[na][nb][nc] == 0)
	{
		visited[na][nb][nc] = 1;
		dfs(na, nb, nc);
	}

	bottle[0] = a;
	bottle[1] = b;
	bottle[2] = c;
	give(0, 2);
	na = bottle[0];
	nb = bottle[1];
	nc = bottle[2];

	if (visited[na][nb][nc] == 0)
	{
		visited[na][nb][nc] = 1;
		dfs(na, nb, nc);
	}

	bottle[0] = a;
	bottle[1] = b;
	bottle[2] = c;
	give(1, 0);
	na = bottle[0];
	nb = bottle[1];
	nc = bottle[2];

	if (visited[na][nb][nc] == 0)
	{
		visited[na][nb][nc] = 1;
		dfs(na, nb, nc);
	}

	bottle[0] = a;
	bottle[1] = b;
	bottle[2] = c;
	give(1, 2);
	na = bottle[0];
	nb = bottle[1];
	nc = bottle[2];

	if (visited[na][nb][nc] == 0)
	{
		visited[na][nb][nc] = 1;
		dfs(na, nb, nc);
	}

	bottle[0] = a;
	bottle[1] = b;
	bottle[2] = c;
	give(2, 0);
	na = bottle[0];
	nb = bottle[1];
	nc = bottle[2];

	if (visited[na][nb][nc] == 0)
	{
		visited[na][nb][nc] = 1;
		dfs(na, nb, nc);
	}

	bottle[0] = a;
	bottle[1] = b;
	bottle[2] = c;
	give(2, 1);
	na = bottle[0];
	nb = bottle[1];
	nc = bottle[2];

	if (visited[na][nb][nc] == 0)
	{
		visited[na][nb][nc] = 1;
		dfs(na, nb, nc);
	}

}



int main()
{
	cin >> limit[0] >> limit[1] >> limit[2];

	bottle[2] = limit[2];
	visited[0][0][limit[2]] = 1;

	v.push_back(limit[2]);

	dfs(0, 0, limit[2]);

	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}
}