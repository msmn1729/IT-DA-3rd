#include<iostream>
#include<vector>
#include<queue>
#include<string>
#include<cstring>

using namespace std;
char mapp[101][101];
int movement[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
string s;
vector<char> v;
queue<pair<int, int>> q;
bool visit[101][101];
int row, col;
int answer;
typedef struct {
	int x;
	int y;
} Current;
Current current;
/*
1. bfs해서 소문자 열쇠 모두 겟.이로인해 딴 문을 통해 또 열쇠를 얻을 수 있다.
2. 열쇠 벡터 생성, 
*/
void bfs() {
	visit[0][0] = true;
	q.push({ 0,0 });
	while (!q.empty()) {
		current.x = q.front().first;
		current.y = q.front().second;
		for (int i = 0; i < 4; i++) {
			int nx = current.x + movement[i][0];
			int ny = current.y + movement[i][1];
			if (nx >= 0 && nx <= row && ny >= 0 && ny <= col && visit[nx][ny] == false && mapp[nx][ny] != '*') {
				if (mapp[nx][ny] == 36) {
					answer++;
				}
				if (mapp[nx][ny] == 46) {
					q.push({ nx,ny });
				}
				else if (mapp[nx][ny] >= 97 && mapp[nx][ny] <= 122) {
					v.push_back(mapp[nx][ny]);
					q.push({ nx,ny });
				}
				else {
					for (int i = 0; i < v.size(); i++) {
						if (mapp[nx][ny] == v[i] - '32') {
							q.push({ nx, ny });
						}
					}
				}
			}
		}
	}
}
int main(void) {
	int tc;
	cin >> tc;
	while (tc--) {
		cin >> row >> col;
		for (int i = 1; i <= col; i++) {
			for (int j = 1; j <= row; j++) {
				cin >> mapp[i][j];
			}
		}
		cin >> s;
		for (int i = 0; i < s.size(); i++) {
			v.push_back(s[i]);
		}
	}
	cout << mapp[1][0];
	return 0;
}