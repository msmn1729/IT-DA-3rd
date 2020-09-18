#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int N;
long long dp[100][21];
vector<int> v;

long long fill(int x, int s)
{
	if (x == N - 2)
	{
		if (s == v[N - 1]) return 1;
		return 0;
	}
	if (dp[x][s] != 0) return dp[x][s];

	if (s + v[x + 1] < 21)
		dp[x][s] += fill(x + 1, s + v[x + 1]);
	if (s - v[x + 1] > -1)
		dp[x][s] += fill(x + 1, s - v[x + 1]);

	return dp[x][s];
}
void init()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int x; cin >> x;
		v.push_back(x);
	}
}
int main()
{
	init();
	cout<<fill(0, v[0]);

	return 0;
}
