#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

//setting
int N, M;
int castle[50][50];
bool visited[50][50] = { false, };
int count = 0;
int roomCount = 0; //방 수
int MaxRoom = 0;  //최대 방 넓이
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };
queue<pair<int, int>> q;


void bfs(int r, int c) {

	while (!q.empty()) {

		q.push(make_pair(r, c));
		
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		visited[r][c] = true;

		//서북동남
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if ((visited[nx][ny] == false) && (nx >= 0) && (nx < M) && (ny >= 0) && (ny < N)) {
				visited[nx][ny] = true;
				q.push(make_pair(nx, ny));
			}
		}
	}

}

int main() {

	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cin >> castle[i][j];
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			bfs(i, j);
		}
	}

}

//다 풀지 못함