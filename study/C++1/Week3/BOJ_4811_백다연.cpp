#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

long long dp[31][31];
//반개를 빼는 경우, 한개를 빼고 반개를 다시 통에 넣는 경우
long long dfs(int tong, int ban)
{
  if(tong == 0) //한개짜리가 없다면
    return 1;
  
  long long &ans  = dp[tong][ban]; //&뭐지..
  if(ans != -1)
    return ans;
  
  ans = 0;
  ans = dfs(tong-1, ban+1); //한개를 빼는 경우 반개를 다시 넣어야함

  if(ban > 0)
    ans += dfs(tong, ban -1); //한개는 그대로고 반개만 줄어들음

    return ans;
}

int main()
{

  while(true)
  {
    memset(dp,-1,sizeof(dp)); //dp 초기화
    int n;
    cin >> n;
    if(n==0) break;  //0이면 종료

    long long ans = dfs(n,0);
    cout << ans << endl;
  }
  
  return 0;
}


   
