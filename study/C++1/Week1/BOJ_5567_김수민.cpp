//5567 결혼식
#include <iostream>
#include <cstdio>
#include <queue>

using namespace std;

unsigned long long g[501][501];
unsigned long long visited[501];
int buddy; //상근이의 직접적인 친구 수
int a, b, n, m;
int cnt = 0, num = 0; //cnt는 while문 실행 횟수(한 사람에 대해 친구를 찾는 횟수), num은 초대할 친구 수
queue<int> q;


void bfs(int N, int buddy, int V) {
	visited[V] = 1;
	q.push(V);
	while (cnt <= buddy) { //친구의 친구까지만 초대해야 하므로, 친구들 수만큼만 탐색한다.
		V = q.front();
		for (int i = 1; i < N + 1; i++) {
			if ((visited[i] == 0) && (g[V][i] == 1)) {
				q.push(i);
				visited[i] = 1;
				num++; //초대할 사람 +!
			}
		}
		q.pop();
		cnt++;
	}
}
int main() {
	cin >> n;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		g[a][b] = g[b][a] = 1;
		if ((a == 1) or (b == 1)) { buddy++; } //1과 직접 연결되어 있으면 상근이의 친구 수 +1 해준다
	}
	bfs(n, buddy, 1);
	cout << num;

}
