#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int main()
{
  int n, m;
  string s;

  cin >> n;
  cin >> m;
  cin >> s;
 
 int answer = 0;
 int cnt = 0;

 for(int i =1; i < m-1; i++)
 {
   if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I')
   {
     cnt++;
     if(cnt == n)
     {
       cnt--;
       answer++;
     }
     i++;
   }
   else cnt = 0;
 }

 cout << answer << endl;
  return 0;
}
