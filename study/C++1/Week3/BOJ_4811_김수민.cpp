#include <iostream>
#include <string>
#include <stdio.h>
#include <deque>
#include <cstring>
#include <algorithm>

using namespace std;
deque <int> a;
long long dp[61][61][61]; //dp[index][w의 개수][h의 개수]

long long pill(int M, int cnt, int w, int h) {
	if (dp[cnt][w][h]!=-1) { return dp[cnt][w][h]; }
	if (cnt == 2 * M - 1) {
		return dp[cnt][w][h]= 1;
	}

	long long answer = 0;

	if (w < M) {
			answer+=pill(M, cnt + 1, w + 1, h); //1개짜리 뽑기
		} 
	if (w != h) {
			answer+=pill(M, cnt + 1, w, h + 1); //반개짜리 뽑기
		}
	
	return dp[cnt][w][h] = answer;
}
int main()
{
	int N;
	for (int i = 0; i < 1000; i++) {
		cin >> N;
		if (N == 0) {
			break;
		}
		a.push_back(N);
	}
	int s = a.size();
	for (int i = 0; i < s;i++) {
		memset(dp, -1, sizeof(dp));
		cout<<pill(a.front(),0, 1, 0)<<"\n";
		a.pop_front();
	}
	
}
