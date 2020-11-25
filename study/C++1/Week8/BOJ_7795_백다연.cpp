#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

//7795 -a가 b를 먹을 수 있는 쌍의 개수
vector <int> a;
vector <int> b;
  int main()
  {
    int t;
    cin >> t;

    while(t--)
    {
      int n, m;
      cin >> n >> m;

      a.clear();
      b.clear();
      int num;
      for(int i = 0; i < n; i++)
      {
          cin >> num;
          a.push_back(num);
      }
      for(int j = 0; j < m; j++)
      {
        cin >> num;
        b.push_back(num);
      }
   
      sort(a.begin(), a.end()); //11378
      sort(b.begin(), b.end()); //136

      int sum = 0;
      int answer = 0;
      for(int i = 0; i < a.size(); i++)
      {
        int j = 0;
        while(j < b.size() && a[i] > b[j])
          j++;
        sum+=j;

      }

      answer+=sum;

      cout << answer << endl;


    }
    
    return 0;
  }


