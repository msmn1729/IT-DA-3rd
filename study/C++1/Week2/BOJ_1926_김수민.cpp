#include <iostream>
#include <cstdio>
#include <cmath>
#include <math.h>
#include <algorithm>

using namespace std;
int paper[501][501];
int check[501][501];
int n, m, cnt,biggest;
int dx[] = { 0,-1,0,1 };
int dy[] = { -1,0,1,0 };
int artsize[251001];

int dfs(int x, int y, int cnt) {
	if (check[x][y] !=0) {
		return 0;
	}
	int temp = 1;
	check[x][y] = cnt;
	for (int i = 0; i < 4; i++) {
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((paper[newx][newy] == 1) && (check[newx][newy] == 0)) {
			temp += dfs(newx, newy, cnt);
		}
	}
	return temp;
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> paper[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if ((check[i][j] == 0)&&(paper[i][j]==1)) {
				cnt++;
				artsize[cnt] = dfs(i, j, cnt);
				biggest = max(biggest, artsize[cnt]);
			}
		}
	}

	
	cout << cnt<<"\n";
	cout << biggest << "\n";
}
