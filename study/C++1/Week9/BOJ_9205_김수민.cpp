#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N;

typedef struct pos {
	int x;
	int y;
}POS;

int cal(POS a, POS b) { //거리 구하는 함수
	return abs(a.x-b.x) + abs(a.y-b.y);
}
int main()
{
	int T;
	cin >> T;
	while (T) {
		int a, b;
		int g[104][104];
		POS v[104];
		cin >> N;
	
		for (int i = 0; i < N + 2; i++) {
			cin >> a >> b;
			v[i].x = a, v[i].y = b; 
		}

		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2;j++) {
				int distance = cal(v[i], v[j]); 
				if (distance > 1000) g[i][j] = -1; //거리를 구해서 1000 넘어가면 (맥주 다 떨어진 상황) -1
				else g[i][j] = 1; 
			}
		}
		for (int k = 0; k < N + 2; k++) { //k는 경유지. 즉 편의점
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0 ; j < N + 2;j++) {
					if (g[i][k] ==1 && g[k][j]==1){ //출발지에서 편의점, 편의점에서 도착지 다 거리가 1000이하 였으면
						g[i][j] = 1; //출발지->도착지에 1을 넣어준다.
					}
				}
			}
		}
		if (g[0][N + 1] == 1) { cout << "happy\n"; } //집->락페스티벌 값이 1이면 
		else { cout << "sad\n"; }
		T--;
	}
}

	