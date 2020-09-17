#include<iostream>
#include<vector>
#include<queue>
using namespace std;

// 1 .x , y 좌표랑 승객을 만났을 때 , 승객 만나고 + 1, 거리

typedef struct {
	int sx;
	int sy;
	int dx;
	int dy;
} Passenger;

Passenger passenger[401];
int N, M, fuel, Tx, Ty;
int arr[21][21];
bool visit[21][21][41];
queue<pair<pair<int, int>, pair<int, int>>> q;
int movement[4][2] = { {-1,0},{0,-1} ,{0,1}, {1,0} };

void bfs(int x, int y) {
	visit[x][y][1] = true;
	q.push({ { x,y }, { 1,0 } });
	while (!q.empty) {
		for (int i = 0; i < 4; i++) {
			int nx = q.front().first.first + movement[4][i];
			int ny = q.front().first.second + movement[4][i];
			if (nx > 0 && nx <= N && ny > 0 && ny <= N && visit[nx][ny][q.front().second.first]) {

			}
		}
	}
}

int main(void) {
	cin >> N >> M >> fuel;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> arr[i][j];
		}
	}
	cin >> Tx >> Ty;
	for (int i = 1; i <= M; i++) {
		cin >> passenger[i].sx >> passenger[i].sy >> passenger[i].dx >> passenger[i].dy;
	}
	return 0;
}