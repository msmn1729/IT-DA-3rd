#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int dp[1001];
int N;

int main()
{
  cin >> N; //돌의 개수


 if(N % 2 == 1) //홀수면
  cout << "SK" << endl;
 else
  cout << "CY" << endl;


  return 0;
}
