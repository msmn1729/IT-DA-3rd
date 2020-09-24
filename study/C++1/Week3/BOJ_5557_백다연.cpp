#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
int arr[101];
int dp[101][31];
int n;
//음수가 나오거나 20을 넘을 수 없음
int cal(int x)
{
  if( x == n) return 0;

  for(int i = 0; i<=20; i++)
    if(dp[x-1][i]!= 0) {
      if(i + arr[x] <= 20) //현재탐색하는 값이랑 앞에값 더하기
        dp[x][i+arr[x]] += dp[x-1][i];
      if(i-arr[x] >= 0)
        dp[x][i-arr[x]] += dp[x-1][i];

    }

}
int main()
{
  memset(dp,0,sizeof(dp));
  cin >> n;
  for(int i=1; i<=n; i++)
    cin >> arr[i];

  dp[1][arr[1]] = 1; //j가 나올 수 있는 경우의 수 저장

    for(int i = 2; i<=n; i++)
      cal(i);

    cout << dp[n-1][arr[n]] << endl;
}


   
