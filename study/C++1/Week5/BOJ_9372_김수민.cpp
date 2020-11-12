#include <iostream>
using namespace std;

int graph[100][100];
int visited[100];
int T, N, M;
int a, b;
int cnt;
int find_num(int V) {
	visited[V] = 1;
	for (int i = 1; i <= N; i++) {
		if ((visited[i] == 0) && (graph[V][i] == 1)) {
			cnt++;
			find_num(i);
		}
	}
	return cnt;
	

}
int main()
{
	cin >> T;
	for (int i = 0; i < T; i++) {
		cnt = 0;
		cin >> N >> M;
		memset(graph, 0, sizeof(graph));
		memset(visited, 0, N);
		for (int j = 0; j < M; j++) {
			cin >> a >> b;
			graph[a][b] = graph[b][a] = 1;
		}
		cout<<find_num(1)<<"\n";
	}
}

