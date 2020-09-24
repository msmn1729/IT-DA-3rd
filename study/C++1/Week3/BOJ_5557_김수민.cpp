#include <iostream>
#include <vector>
#include <string>
#include <cstring>

using namespace std;
int a[101];
int N;
long long dp[101][25];
int cnt = 0;

long long cal(int cnt, int sum) {	
	if ((sum < 0) or (sum > 20)) { return 0; }
	
	if (cnt == N - 2) {
		if (sum == a[N - 1]) { //마지막 값이랑 같으면
			return dp[cnt][sum] = 1;
		}
		return dp[cnt][sum] = 0;
	}
	if (dp[cnt][sum] != -1) { return dp[cnt][sum]; }
	long long answer = 0;
	answer+=cal(cnt + 1, sum + a[cnt+1]); //덧셈 
	answer+=cal(cnt + 1, sum - a[cnt+1]); //뺄셈

	return dp[cnt][sum]=answer;

}

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}
	memset(dp, -1, sizeof(dp));
	cout<<cal(0, a[0]);
    
}
