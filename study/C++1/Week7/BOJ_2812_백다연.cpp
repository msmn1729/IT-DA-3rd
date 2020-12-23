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
    vector<char> v;
    int n, k;
    string num;
    cin >> n >> k;
    cin >> num;

    for (int i = 0; i < n; i++)
    {
      //아직 지울 수 있고 
      while (k > 0 && !v.empty() && v.back() < num[i])
      {
        v.pop_back();
        k--;
      }
      v.push_back(num[i]);
    }

    for (int i = 0; i < v.size() - k; i++)
      cout << v[i];

    return 0;
  }


