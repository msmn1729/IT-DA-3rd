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
  int t,n;
  vector <string> v;
  char s[10001];
 
  cin >> t;

  while(t--)
  {
    bool change = 0;
    cin >> n;
    for(int i = 0 ; i < n; i++)
    {
      cin >> s;
      v.push_back(s);
    }
    sort(v.begin(), v.end());

    for(int i = 0; i < n-1; i++)
    {
      int current = v[i].length();
      int next = v[i+1].length();

      if(current >= next)
        continue;
      if(v[i+1].substr(0,current) == v[i])
      {
        cout << "NO" << endl;
        change = 1;
        break;
      }
  }
  if(change == 0)
    cout << "YES" << endl;


    v.clear();

  
  }
  return 0;
}
