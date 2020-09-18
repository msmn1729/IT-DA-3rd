#include<iostream>
#include<vector>
#include<cstring>

using namespace std;
vector<int> v;
long long N;
long long d[101][21];

// 백트래킹으로 풀면 시간초과 난다.
// 어차피 결과가 될 수 있는건 0 부터 20 까지
// 결과값을 모두 알맞은 자리에 넣어준다 . 전형적인 dp...
long long dp(int n, int result, int sum) {
	if (sum < 0 || sum > 20) {
		return 0; //
	}
	if (n == N - 1) { // 마지막에 다 다랐을 때
		if (sum == result) // sum이 결과과 같으면 return 1
			return 1;
		else // sum이 결과와 다르면 return 0
			return 0;
	}
	if (d[n][sum] != -1) { // dp를 쓰는 이유
		return d[n][sum];
	}
	d[n][sum] = dp(n + 1, result, sum + v[n]) + dp(n + 1, result , sum - v[n]);
	return d[n][sum];
}
int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		v.emplace_back(num);
	}
	memset(d, -1, sizeof(d));
	cout << dp(1, v[N-1], v[0]);
	return 0;
}
/*
void dfs(int n, int result, int sum ) {
	if (n == v.size() - 2 && sum == result) {
		answer++;
		return;
	}
	if (n == v.size() - 1) {
		return;
	}
	if (sum < 0 || sum > 20) {
		return;
	}
	if (sum + v[n + 1] <= 20) dfs(n + 1, result, sum + v[n + 1]);
	if (sum + v[n + 1] >= 0) dfs(n + 1, result, sum - v[n + 1]);
}
int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		v.emplace_back(num);
	}
	dfs(0, v[N-1], v[0]);
	cout << answer;
	return 0;
}
*/