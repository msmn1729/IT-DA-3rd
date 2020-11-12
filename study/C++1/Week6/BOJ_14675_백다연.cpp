#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
vector <int> v[100001];
//시간초고 수정해야함
int main()
{
  int n;
  cin >> n;
  for(int i = 1; i < n; i++)
  {
    int a,b;
    cin >> a >> b;

    v[a].push_back(b);
    v[b].push_back(a);
  }

  int q;
  cin >> q;

  while(q--)
  {
    int x, y;
    cin >> x >> y;
    if(x == 1)
    {
      if(v[y].size() >=2 ) //노드 두개면 무조건 생김
        cout << "yes" << endl;
      else
        cout << "no" << endl;

    }
    else
      cout << "yes" << endl; //단절선은 무조건 두개 됨
  }
  
  return 0;
}
