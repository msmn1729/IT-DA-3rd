#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
int n;
bool prime(int a)
{
  int s = sqrt(a);
  for(int i = 2; i <=s; i++)
  {
    if( a % i == 0)
        return false;
  }
  return true;
}

bool ispal(string pal, string rev)
{
  if(pal == rev)
    return true;
  else
  {
    return false;
  }
  
}

int main()
{

  cin >> n;
  if(n == 1) {
    cout << 2 << endl;
    return 0; }

  while(true)
  {
    string pal = to_string(n);
    string rev = to_string(n);

    reverse(rev.begin(), rev.end());

    if(ispal(pal, rev))
    {
      if(prime(n))
      {
        cout << n << endl;
        return 0;
      }
    }
    n++;
  }


  
  return 0;
}
