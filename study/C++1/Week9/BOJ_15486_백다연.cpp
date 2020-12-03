#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
//15486
using namespace std;

int main()
{
  int n;
  vector <pair<int, int>> v;
  
  int dp[1500002];
  int t, p;

  int T[1500001];
  int P[1500001];

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);


  cin >> n;
  //v.push_back(make_pair(0,0));
  
  for(int i = 1; i <=n; i++) {
    cin >> T[i] >> P[i];
    //v.push_back(make_pair(t,p));
  }
  

  int ans = 0;
  for(int i = 1; i <=n; i++) { 
    dp[i + T[i]] = max(dp[i +T[i]], dp[i] + P[i]); //저장된 값이랑 더한 값이랑 더 큰 값 저장
    dp[i + 1] = max(dp[i + 1], dp[i]);
  }

  cout << dp[n+1] << endl;

  return 0;
  
}