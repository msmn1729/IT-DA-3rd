#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int N;

int arr[1000001];

int dp[1000001];

int main()
{

  int cnt = 0;

  cin >> N;

  for (int n = 0; n < N; n++)
    cin >> arr[n];

  for (int n = 0; n < N; n++)
  {

    cnt = max(cnt, dp[arr[n]] = dp[arr[n] - 1] + 1);
  }

  cout << N- cnt << endl;

  return 0;
}
