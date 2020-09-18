#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;

int arr[17][17];
int N, M, D,idx, result, maximum;
vector<int> n;
vector<int> ind;
vector<int> archer[455];
queue<pair<int, int>> q;

void Combi() {
	for (int i = 1; i <= N; i++) {
		n.push_back(i);
	}
	int k = 3;
	for (int i = 0; i < k; i++) {
		ind.push_back(1);
	}
	for (int i = 0; i < n.size() - k; i++) {
		ind.push_back(0);
	}
	sort(ind.begin(), ind.end());
	do {
		for (int i = 0; i < ind.size(); i++) {
			if (ind[i] == 1) {
				archer[idx].push_back(n[i]);
			}
		}
		idx++;
	}while(next_permutation(ind.begin(), ind.end()));
}

int bfs(int a1, int a2, int a3) {
	result = 0;
	q.push({ N + 1,a1 });
	q.push({ N + 1,a2 });
	q.push({ N + 1,a3 });
	return result;

}
int main(void) {
	cin >> N >> M >> D;
	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> arr[i][j];
		}
	}
	Combi();

	for (int i = 0; i < idx; i++) {
		for (int j = 0; j < archer[i].size(); j++) {
			bfs(archer[i][0], archer[i][1], archer[i][2]);
			maximum = max(result, maximum);
		}
	}
	cout << maximum;
	return 0;
}