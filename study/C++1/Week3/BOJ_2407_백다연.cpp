#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
int n,m;
string dp[101][101];

string addnum(string x, string y)
{
  long long sum = 0;
  string result;

  while(!x.empty() || !y.empty() || sum)
  {
    if(!x.empty())
    {
      sum += x.back() - '0';
      x.pop_back();
    }
    if(!y.empty())
    {
      sum+= y.back() - '0';
      y.pop_back();
    }
    result.push_back((sum % 10) + '0');
    sum /= 10;
  }
  reverse(result.begin(), result.end()); //1의 자리부터 넣어서 다시 뒤집어야함
  return result;
}

string combination(int n, int r)
{
  if(n==r || r ==0)
    return "1";

  string &result = dp[n][r];
  if(result != "")
    return result;

  result = addnum(combination(n-1,r-1), combination((n-1),r));
  return result;
}

int main()
{
  cin >> n >> m;

  cout << combination(n,m) << endl;
   return 0;
}
