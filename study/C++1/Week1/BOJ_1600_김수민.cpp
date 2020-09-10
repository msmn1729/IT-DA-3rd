#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;
int K,W,H;
int map[200][200];
int visited[31][200][200];
struct ST { int x; int y; int cnt; int k; };
queue <ST> q;
int dx[4] = { 0,0,1,-1 }; //상하좌우 움직이는
int dy[4] = { 1,-1,0,0 };
int xhorse[8] = { 2,1,-1,-2,-2,-1,1,2 }; //말처럼 움직이는 
int yhorse[8] = { 1,2,2,1,-1,-2,-2,-1 };

int bfs() {
	while (!q.empty()) {
		ST a = q.front(); //기준 점을 큐의 맨 처음 값으로 잡고
		q.pop(); //pop해준다
		if ((a.x == W - 1) && (a.y == H - 1)) { //도착점 도달했을 때 움직인 횟수 센거 출력
			return a.cnt;
		}

		if (a.k < K) { //말 이동 횟수 아직 다 안썼으면
			for (int i = 0; i < 8; i++) { //이동
				ST b;
				b.x = a.x + xhorse[i]; b.y = a.y + yhorse[i];
				if (b.x >= 0 && b.x <= H && b.y >= 0 && b.y <= W) { //이동 할 위치가 범위 내에 들어있으면
					if ((visited[a.k + 1][b.x][b.y] == 0) && (map[b.x][b.y] == 0)) { //다음으로 갈 곳이 방문 안한 지점이고, 장애물이 없다면
						visited[a.k + 1][b.x][b.y] == 1; //이동하고 방문했다고 값을 바꾸고
						b.cnt = a.cnt + 1; b.k = a.k + 1; //움직인 횟수와 K(말 이동 횟수)를 하나씩 증가시킨다
						q.push(b); //큐에 push
					}
				}
			}
		}
		else { //말 이동 횟수를 다썼으면
			for (int i = 0; i < 4; i++) {
				ST b;
				b.x = a.x + dx[i]; b.y = a.y + dy[i];
				if (b.x >= 0 && b.x <= H && b.y >= 0 && b.y <= W) { //이동 할 위치가 범위 내에 들어있고
					if ((visited[a.k][b.x][b.y] == 0) && (map[b.x][b.y] == 0)) { //다음으로 갈 곳이 방문 안한 지점이고 장애물이 없다면
						visited[a.k][b.x][b.y] == 1; //이동하고 방문했다고 값을 바꾸고
						b.cnt = a.cnt + 1; //움직인 횟수를 하나 증가시킨다
						q.push(b); //큐에 푸쉬
					}
				}
			}
		}
	}
	return -1; //불가능하면 -1출력
}


int main()
{
	cin >> K;
	cin >> W >> H;
	for (int i = 0; i < H; i++) { //길을 mao배열에 입력 받는다
		for (int j = 0; j < W; j++) {
			cin >> map[i][j];
		}
	}

	ST a; 
	a.x = 0; a.y = 0; a.cnt = 0; a.k = 0; //구조체 a를 초기화하고
	q.push(a); //큐에 넣어주고 
	visited[0][0][0] = 1; //처음 지점을 방문했다고 바꿔준다.

	cout << bfs();
}

