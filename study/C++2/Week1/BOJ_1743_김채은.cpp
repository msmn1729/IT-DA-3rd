/* BOJ_1743 */

#include <iostream>

using namespace std;

#define MAX 100
int N, M, K;	//세로, 가로, 음식물 개수
int path[MAX][MAX] = { -1, };
bool visited[MAX][MAX] = { false, };

void Input(){
	cin >> N >> M >> K;

	for(int i=0; i<K; i++){
		int r, c;
		cin >> r >> c;
		path[r-1][c-1]=1;
	}
}

int DFS(int x, int y){
	visited[x][y] = true;

	int trashSize = 0;
	trashSize++;

	if (x - 1 >= 0 && x + 1 < M) {
		if (path[x - 1][y] == '1' && !visited[x - 1][y])
			trashSize += DFS(x - 1, y);
		if (path[x + 1][y] == '1' && !visited[x + 1][y])
			trashSize += DFS(x + 1, y);
	}

	if (y - 1 >= 0 && y + 1 < N) {
		if (path[x][y - 1] == '1' && !visited[x][y - 1])
			trashSize += DFS(x, y - 1);
		if (path[x][y + 1] == '1' && !visited[x][y + 1])
			trashSize += DFS(x, y + 1);
	}
	return trashSize;
}

void Solution() {
	int result = -1;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int trashSize=0;

			if(path[i][j]=='1' && !visited[i][j])
				trashSize = DFS(i,j);

			if(trashSize>result)
				result = trashSize;
		}
	}

	cout << result;
}

int main(){
	Input();
	Solution();
	return 0;
}
