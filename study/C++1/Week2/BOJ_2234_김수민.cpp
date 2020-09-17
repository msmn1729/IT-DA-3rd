#include <iostream>
#include <math.h>
#include <cmath>
#include <algorithm>
#include <cstdio>

using namespace std;
int n,m,cnt,maxsize,biggest;
int castle[51][51];
int visited[51][51];
int roomsize[3000];
int dx[] = { 0,-1,0,1 };
int dy[] = { -1,0,1,0 };


int dfs(int x, int y, int cnt) {
	int temp = 1;
	if (visited[x][y]!=0) { return 0; }
	visited[x][y] = cnt;
	for (int i = 0; i < 4; i++) {
		if (!(castle[x][y] & (1 << i))) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			temp += dfs(nx, ny, cnt);
		}
	}return temp;
}
int main()
{
	int a, b;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> castle[i][j];
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j] == 0) {
				cnt++;
				roomsize[cnt]=dfs(i, j, cnt);
				maxsize = max(maxsize, roomsize[cnt]);

			}

		}
	}
	for (int i = 0; i < m;i++) {
		for (int j = 0; j < n; j++) {
			if (i+1<m){
				a = visited[i + 1][j];
				b = visited[i][j];
				if (a != b) { biggest = max(biggest, roomsize[a] + roomsize[b]); }
			}
			if (j + 1 < n) {
				a = visited[i][j + 1];
				b = visited[i][j];
				if (a != b) { biggest = max(biggest, roomsize[a] + roomsize[b]); }
			}

		}
	}
	cout << cnt << "\n";
	cout << maxsize << "\n";
	cout << biggest << "\n";
}

