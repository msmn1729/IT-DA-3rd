#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int n, m;
int map[500][500] = {};
bool visited[500][500] = { false, };
int picCnt = 0;
int picMax = 0;
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };
queue<pair<int, int>> q;



void bfs(int x, int y) {

	q.push(make_pair(x, y));
	int nx = q.front().first;
	int ny = q.front().second;
	q.pop();

	visited[x][y] = true;

	while (!q.empty()) {
		for (int i = 0; i < 4; i++) { //µ¿ºÏ¼­³²
			int nnx = nx + dx[i];
			int nny = ny + dy[i];
			if (visited[nnx][nny] == false && nnx >= 0 && nny >= 0 && nnx < m && nny < n)
			{
				visited[nnx][nny] = true;
				q.push(make_pair(nnx, nny));
			}
		}picCnt++;

	}




}

int main() {

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			bfs(i, j);
		}
	}

	cout << picCnt << picMax << endl;;



}