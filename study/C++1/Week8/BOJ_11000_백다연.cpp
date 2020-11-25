#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

//11000

pair<int, int> v[200001];
priority_queue<int, vector<int>, greater<int>> pq;

int main()
{
  int n;
  cin >> n;

  int s,t;
  for(int i = 0; i < n; i++)
  {
    cin >> s >> t;
    v[i].first = s;
    v[i].second =t;
  }

  sort(v, v+n);
  pq.push(v[0].second);

  for(int i = 1; i < n; i++)
  {
    if(pq.top() <= v[i].first)
    {
      pq.pop();
      pq.push(v[i].second);
    }
    else
    {
      pq.push(v[i].second);
    }
    
  }

  cout << pq.size() << endl;
  
  return 0;
}


