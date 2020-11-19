#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
long long n, m;
int make[1000000];
bool check(long long t)
{
  long long ball = 0;
  for(long long i = 0; i < n; i++)
    ball += t / make[i];
  return ball >= m;
}

int main()
{
 cin >> n >> m;

int maxtime = 0;
 for(int i = 0; i < n; i++)
 {
   cin >> make[i];
   if(maxtime <=make[i])
      maxtime = make[i];
 }

 long long left = 0;
 long long right = maxtime * m;

 while(left <= right)
 {
   long long mid = (left + right) /2;
   if(check(mid))
    right = mid -1;
  else
  {
    left = mid + 1;
  }
  

 }

 cout << left << endl;
  return 0;
}

