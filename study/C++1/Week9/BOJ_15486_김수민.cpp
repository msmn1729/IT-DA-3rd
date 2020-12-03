#include <iostream>
#include <algorithm>

using namespace std;
int N;
typedef struct {
	unsigned int day;
	unsigned int price;
}S;
S bye[3000002];
unsigned int dp[1500001];

int main()
{
	cin >> N;
	for (int i = 1; i < N + 1; i++) {
		cin >> bye[i].day >> bye[i].price;
	}

	for (int i = 1; i < N + 1; i++) {
		if (i + bye[i].day - 1 <= N) { //상담 가능
			dp[i + bye[i].day] = max(dp[i + bye[i].day], dp[i] + bye[i].price);

		}
		//상담 못하면
		dp[i + 1] = max(dp[i + 1], dp[i]);

	}


	cout << dp[N + 1] << "\n";
}

