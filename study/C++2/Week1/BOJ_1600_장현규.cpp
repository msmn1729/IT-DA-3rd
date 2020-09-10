#include<iostream>
//인터넷에 올라와 있는 bfs강의를 보고 최대한 비슷하게 만들어 봤는데 작동이 되지 않습니다ㅠㅠ
int w, h;
int wh[201][201] = { 0 };
int visit[201][201] = { 0 }; 
int dexit = 0;
int normalx[4] = { 1,-1,0,0 }, normaly[4] = { 0,0,1,-1 }, horsemovex[8] = { 1,2,-1,-2,1,2,-1,-2 }, horsemovey[8] = { 2,1,2,1,-2,-1,-2,-1 };
using namespace std;
int pathfinder(int x,int y,int k) {
	if (x == w - 1 && y == h - 1) {
		return 0;
	}
	if (x >= w || y >= h) {
		return 0;
	}
	visit[y][x] = 1;
	int nx, ny;
	if (k > 0) {
		for (int i = 0; i < 8; i++) {
			nx = x + horsemovex[i];
			ny = y + horsemovey[i];
			if (nx == w - 1 && ny == h - 1) {
				continue;
			}
			if (nx < 0 || ny < 0) {
				continue;
			}
			if (wh[y][x] == 1 || visit[y][x] == 1) {
				continue;
			}
			pathfinder(nx, ny, k - 1);
		}
	}
	for (int i = 0; i < 4; i++) {
		nx = x + normalx[i];
		ny = y + normaly[i];
		if (nx == w - 1 && ny == h - 1) {
			continue;
		}
		if (nx < 0 || ny < 0) {
			continue;
		}
		if (wh[y][x] == 1 || visit[y][x] == 1) {
			continue;
		}
		pathfinder(nx, ny, k);
	}
	if (nx != w - 1 && ny != h - 1) {
		pathfinder(nx, ny, k);
	}
	visit[y][x] = 0;
	return 0;
}
int main(void) {
	int k,x,y;
	int j,i;
	x = y = 0;
	cin >> k;
	cin >> w >> h;
	for (i = 0; i < h; i++) {
		for (j = 0; j < w; j++) {
			cin >> wh[i][j];
		}
		wh[i][j] = 1;
	}
	for (j = 0; j <= w; j++) {
		wh[i][j]=1;
	}for (i = 0; i <=h; i++) {
		for (j = 0; j <=w; j++) {
			cout<< wh[i][j];
		}
		cout << endl;
	}
	pathfinder(0, 0, k);
	return 0;
}