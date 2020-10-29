#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int dp[101][1001]; // 앞에는 곡의 개수 뒤에는 최대 볼륨
int arr[101];

int main()
{
  int N, S, M;
  cin >> N >> S >> M;
  //곡의 개수 만큼 입력받고
  for (int i = 0; i < N; i++)
  {
    cin >> arr[i];
  }

  //첫번째곡 계산
  if (S + arr[0] <= M)
    dp[0][S + arr[0]] = 1;
  if (S - arr[0] >= 0)
    dp[0][S - arr[0]] = 1;

  for (int i = 1; i < N; i++)
  {
    int next = i;
    int pre = i - 1;

    for (int j = 0; j <= M; j++)
    {
      if (dp[pre][j] == 1)
      {
        if (j + next <= M)
          dp[next][j + next] = 1;
        if (j - next >= 0)
          dp[next][j - next] = 1;
      }
    }
  }

  int maxvalue = -1;
  for (int i = 0; i <= M; i++)
  {
    if (dp[N - 1][i] == 1) //저장된 볼륨
    {
      maxvalue = i;
    }
  }

  cout << maxvalue;

  return 0;
}
