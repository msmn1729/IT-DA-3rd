#include <iostream>
using namespace std;
double p[4];
int visited[30][30] = { 0, };

int num;
double ans = 0;

int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

void dfs(int cx, int cy, int move, double per)
{
	if (move == num)		//정해진 횟수만큼 움직이면 확률 계산하고 함수 종료
	{
		ans += per;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int nx = cx + dx[i];
		int ny = cy + dy[i];

		if (visited[nx][ny] == 0)
		{
			visited[nx][ny] = 1;
			int nm = move + 1;
			double np;
			if (move == 0) np = p[i];
			else np = per * p[i];

			dfs(nx, ny, nm, np);

			visited[nx][ny] = 0;
		}
	}
}


int main()
{
	cin >> num;
	for (int i = 0; i < 4; i++)
	{
		cin >> p[i];
		p[i] /= 100;
	}
	visited[15][15] = 1;

	dfs(15, 15, 0, 0);

	cout.precision(9);		//오차를 소수점 아래 9자리까지 허용하므로 소수점 아래 9자리 이상 표현해야 함
	cout << fixed;
	cout << ans;


}