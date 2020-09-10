#include <iostream>
#include<vector>
#include<queue>
using namespace std;

int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int hdx[] = { 1, -1, 2, -2, 1, -1, 2, -2 };
int hdy[] = { 2, 2, 1, 1, -2, -2, -1, -1 };
int map[200][200];


int main()
{
	int K, W, H;
	cin >> K >> W >> H;

	for (int i = 0; i < W; i++)
	{
		for (int j = 0; j < H; j++)
		{
			cin >> map[i][j];
		}
	}

	queue<pair<pair<int, int>, int>> q;
	q.push(make_pair(make_pair(0, 0), K));

	while (!q.empty())
	{
		int x = q.front().first.first;
		int y = q.front().first.second;
		int count = q.front().second;

		q.pop();

		if (count > 0)
		{
			for (int i = 0; i < 8; i++)
			{

			}
		}
	}

}