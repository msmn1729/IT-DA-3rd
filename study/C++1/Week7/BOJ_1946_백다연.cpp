#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int main()
{
  int t, n, paper, interview;
  vector <pair<int,int>> v;
  cin >> t;

  while(t--)
  {
    v.clear();
    cin >> n;

    for(int i = 0; i < n; i++)
    {
      cin >> paper >> interview;
      v.push_back(make_pair(paper,interview));
    }
    
    sort(v.begin(), v.end()); //first만 정렬

    int num = v[0].second; // 서류 1등의 면접점수
    int ans= 1;

    for(int i = 1; i <n; i++)
    {
      if(num >= v[i].second)
        {
          num = v[i].second;
          ans++;
        }
    }

    cout << ans << endl;

  }


  return 0;
}