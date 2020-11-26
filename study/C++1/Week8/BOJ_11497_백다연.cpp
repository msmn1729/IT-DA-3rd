#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

//11497 
//시간초과
vector <int> v;
vector<int> maxarray;
int main()
{
  int t;
  cin >> t;

  while (t--)
  {
    int n;
    cin >> n;
    int arr[100001];
    v.clear();
    maxarray.clear();
    for (int i = 0; i < n; i++)
    {
      cin >> arr[i];
    }

    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        int value = arr[i] - arr[j];
        if (value < 0)
          value = value * (-1);
        v.push_back(value);
      }
      int maxnum = *max_element(v.begin(), v.end());
      maxarray.push_back(maxnum);
    }

    cout << *min_element(maxarray.begin(), maxarray.end()) << endl;
  }
  return 0;
  }


