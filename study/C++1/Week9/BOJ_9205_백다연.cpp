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
int t;
int x, y;
int check;
int nx, ny;
int ex, ey;
int visit[110];
vector<pair<int, int>> v;

void DFS(int a, int b)
{
  int num;

  num = abs(ex - a) + abs(ey - b); //거리 계산

  if (check == 1 || num <= 1000)
  {
    check = 1;
    return;
  }

  for (int i = 0; i < v.size(); ++i)
  {
    if (visit[i] == 1)
    {
      continue;
    }

    num = abs(v[i].first - a) + abs(v[i].second - b);

    if (num > 1000)
    {
      continue;
    }
    else
    {
      visit[i] = 1;
      DFS(v[i].first, v[i].second);
    }
  }
}

int main(int argc, char *argv[])
{
  cin >> t;

  while (t--)
  {
    cin >> n;
    cin >> nx >> ny;

    v.clear();
    memset(visit, 0, sizeof(visit));

    for (int i = 0; i < n; ++i)
    {
      cin >> x >> y;
      v.push_back(make_pair(x, y));
    }
    cin >> ex >> ey;

    check = 0;
    DFS(nx, ny);

    if (check == 1)
    {
      cout << "happy" << endl;
    }
    else
    {
      cout << "sad" << endl;
    }
  }
  return 0;
}