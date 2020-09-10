/* BOJ_5567 */
#include <iostream>
#include <vector>

using namespace std;

#define MAX 500 + 1

int N, M;
vector<int> friends[MAX];
bool friendsList[MAX];

void Input() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;

		friends[a].push_back(b);
		friends[b].push_back(a);
	}
}

void findFriends(int n) {
	//친구 관계 파악
	for (int i = 0; i < friends[n].size(); i++) {
		int next = friends[n][i];
		friendsList[next] = true;
	}

	//상근이의 친구 찾기
	if (n == 1) {
		for (int i = 0; i < friends[n].size(); i++) {
			int next = friends[n][i];
			findFriends(next);
		}
	}
}

int countFriends() {
	int cnt = 0;
	for (int i = 2; i <= N; i++)
		if (friendsList[i])
			cnt++;
	return cnt;
}

void Solution() {
	findFriends(1);
	cout << countFriends() << endl;
}

int main(void) {

	Input();
	Solution();

	return 0;
}



