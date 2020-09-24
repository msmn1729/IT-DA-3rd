#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>

using namespace std;
int N, M,circle;
int g[16][16];
int cnt = 0;
int dx[] = { 1,0 };
int dy[] = { 0,1 };
int dp[50][50];

int find(int x, int y) {
	int allow=0;
	int V = g[x][y];
	if (V == circle) {
		allow = 1;
	}
	if (V == cnt) {
		if (circle == 0) {
			return dp[x][y] = 1;
		}
		else if (allow == 1) {
			return dp[x][y] = 1;
		}
		return dp[x][y]=0;
	}
	if (dp[x][y] != -1) {
		return dp[x][y];
	}
	long long answer = 0;
	for (int i = 0; i < 2; i++) {
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((newx >= 0) && (newx < N) && (newy >= 0) && (newy < M)) {
			answer += find(newx, newy);
		}
		
	}
	return dp[x][y]= answer;

}

int main()
{
	cin >> N >> M;
	cin >> circle;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cnt++;
			g[i][j] = cnt;
			
		}
	}
	memset(dp, -1, sizeof(dp));
	cout<<find(0, 0);
}