#include<iostream>
//재귀를 이용하여 풀어보았습니다.
using namespace std;
int location[30][30] = { {0} };
int horizontal[4] = { 1,-1,0,0 };
int vertical[4] = { 0,0,-1,1 };
double chance[4];
double pathfinder(int x,int y,int count) {
	int newx=x, newy=y;
	double chances=0;
	if (count == 0) {
		return 1;
	}
	location[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		newx = x + horizontal[i];
		newy = y + vertical[i];
		if (location[newy][newx] == 1) {
			continue;
		}
		chances += chance[i] * pathfinder(newx, newy,count-1);
	}
	location[y][x] = 0;
	return chances;
}
int main(void) {
	int move;
	cin >> move >> chance[0] >> chance[1] >> chance[2] >> chance[3];
	for (int i = 0; i < 4; i++) {
		chance[i] /= 100;
	}
	cout << pathfinder(15, 15, move);
	return 0;
}