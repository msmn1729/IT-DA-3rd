#include<iostream>
#include<vector>

using namespace std;

int movement[4][2] = { {1,0},{-1,0} ,{0,1},{0,-1} };
int n, L, R, U, D;
bool visit[33][33]; //넉넉히 33개로
double result;
vector<double> v;

/*
bfs로 접근하려다가 그림그려보고 dfs로 전환 , 리프노드부터 탐색해서 올라가는게 적절할 것 같음.
밞은곳 방문처리,,, 그럼 안밝게됨,,, 최종적으로 n 번 움직였을때 모든 확률 더해서 출력해주면됨
음,,, length가 n일때 return을 하면 안되려나... ->이게 문제가 아니고 소수점 문제였음 ㅅㅂ...
*/
void dfs(int x, int y,int length, double value) {
	if (length == 0) { // length번 움직이면 return
		result += value;
		return;
	}
	visit[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nx = x + movement[i][0];
		int ny = y + movement[i][1];
		if (visit[nx][ny] == false) { //밟지 않았으면 가기 
			dfs(nx, ny, --length, value * v[i]); //1번 움직이는 것이니 --length , value 에다가 방향확률 v[i] 곱하기 , 방향은 크게 노상관 어느방향이든 확률은 알아서 계산이 될것임.
			length++; // dfs에서 나온거니 다시 ++
			visit[nx][ny] = false; // 밟지 않은곳이어야하니 false처리
		}
	}
}

int main(void) {
	cin >> n >> L >> R >> D >> U;
	v.emplace_back(L * 0.01);
	v.emplace_back(R * 0.01);
	v.emplace_back(D * 0.01);
	v.emplace_back(U * 0.01);
	dfs(15, 15, n, 1.0); //중간은 15니 (15,15) 로
	cout<<fixed; // 아오 개빡쳐 이거 소숫점 썅
	cout.precision(10); //10 적으면 9자리까지 나온다고 함.
	cout << result;
	return 0;
}