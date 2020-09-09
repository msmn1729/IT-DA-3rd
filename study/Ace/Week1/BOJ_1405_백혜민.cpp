#include <iostream>
#include <iomanip>
#include <queue>
using namespace std;

int dx[] = { 1,-1,0,0 };//µ¿¼­³²ºÏ
int dy[] = { 0,0,1,-1 };
int N, est, wst, sth, nth;
bool visit[30][30];
double answer;

void dfs(int x, int y, int num, double sum)
{
	visit[x][y] = true;
	//cout << x << " " << y << " " << num << " " << sum << endl;
	if (num == N)
	{
		answer += sum; return;
	}
	for (int k = 0; k < 4; k++)
	{
		int nx = x + dx[k]; int ny = y + dy[k];

		if (!visit[nx][ny])
		{
			switch (k)
			{
			case 0:
				dfs(nx, ny, num + 1, sum * (double)est*0.01); break;
			case 1:
				dfs(nx, ny, num + 1, sum * (double)wst*0.01); break;
			case 2:
				dfs(nx, ny, num + 1, sum * (double)sth*0.01); break;
			case 3:
				dfs(nx, ny, num + 1, sum * (double)nth*0.01); break;
			}
			visit[nx][ny] = false;
		}
	}
}
void init()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> est >> wst >> sth >> nth;
}
int main()
{
	init();
	dfs(15, 15, 0, 1);
	cout << setprecision(10)<<answer;

	return 0;
}