#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
int arr[201][201] = { 0 };
int visited[201][201][31] = { 0 };
int dh[12] = { -2,-2,2,2,-1,1,-1,1,-1,1,0,0 };
int dw[12] = { -1,1,-1,1,-2,-2,2,2,0,0,-1,1 };
int main() {
	int K, W, H, h, w, k, cnt, result = -1;
	cin >> K >> W >> H;
	for (int i = 1; i <= H; i++)
	{
		for (int j = 1; j <= W; j++)
		{
			cin >> arr[i][j];
		}
	}
	queue<pair<pair<int, int>, pair<int, int>>> q; // (hÁÂÇ¥, wÁÂÇ¥),(³ªÀÌÆ® ÀÌµ¿È½¼ö,ÃÑ È½¼ö)
	q.push(make_pair(make_pair(1, 1), make_pair(0, 0)));
	while (!q.empty())
	{
		h = q.front().first.first;
		w = q.front().first.second;
		k = q.front().second.first;
		cnt = q.front().second.second;
		q.pop();
		if (h == H && w == W)
		{
			result = cnt;
			break;
		}
		for (int i = 0; i < 12; i++)
		{
			if (h + dh[i] < 1 || h + dh[i] > H || w + dw[i] < 1 || w + dw[i] > W)
				continue;
			if (i >= 0 && i < 8 && k < K)
			{
				if (visited[h + dh[i]][w + dw[i]][k + 1] == 0 && arr[h + dh[i]][w + dw[i]] == 0)
				{
					q.push(make_pair(make_pair(h + dh[i], w + dw[i]), make_pair(k + 1, cnt + 1)));
					visited[h + dh[i]][w + dw[i]][k + 1] = 1;
				}
			}
			else if (i >= 8)
			{
				if (visited[h + dh[i]][w + dw[i]][k] == 0 && arr[h + dh[i]][w + dw[i]] == 0)
				{
					q.push(make_pair(make_pair(h + dh[i], w + dw[i]), make_pair(k, cnt + 1)));
					visited[h + dh[i]][w + dw[i]][k] = 1;
				}
			}
		}
	}

	cout << result;
}
