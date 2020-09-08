#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
using namespace std;

int n, m;
int arr[501][501];
int visit[501];
vector<int> v[501];
queue<pair<int, int>> ring;
//결혼식
//자꾸 틀리다고나오는데 이유를 모르겠어서 고쳐야함

int main()
{
  cin >> n;
  cin >> m;

  for (int i = 0; i < m; i++)
  {
    int a, b;
    cin >> a >> b;
    v[a].push_back(b);
    v[b].push_back(a);
  }
  visit[1] = 1; //1은 항상방문

  for (int i = 0; i < v[1].size(); i++)
  {
    ring.push(make_pair(v[1][i], 1)); //1과 연결된 점을 저장
  }

  int cnt = 0;
  while (!ring.empty())
  {
    int now = ring.front().first;
    int stair = ring.front().second;

    if (stair == 3)
      break;
    if (visit[now] == 1) //이미 방문한 지점이라면
    {
      ring.pop();
      continue;
    }

    else
    {
      cnt++;
      visit[now] = 1;
      ring.pop();

      for (int i = 0; i < v[now].size(); i++)
      {
        int next = v[now][i];
        ring.push(make_pair(next, ++stair)); //연결된 단계와 함께 넘기기
      }
    }
  }
  cout << cnt << endl;
}
