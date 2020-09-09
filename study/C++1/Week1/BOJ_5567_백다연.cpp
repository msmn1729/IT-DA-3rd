#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
using namespace std;

int n, m;
//int arr[501][501];
int visit[501];
vector<int> v[501];

void bfs(int start)
{
  visit[start] = 1;
  queue<int> q;
  q.push(start);

  while (!q.empty())
  {
    int now = q.front();
    q.pop();

    for (int i = 0; i < v[now].size(); i++)
    {
      int next = v[now][i]; //현재 탐색하는 노드랑 연결된곳
      if (visit[next] == 0) //연결된 노드가 방문하지 않았다면
      {
        visit[next] = visit[now] + 1; //연결점 하나차이이므로 +1
        q.push(next);
      }
    }
  }
}

int main()
{
  cin >> n;
  cin >> m;

  for (int i = 0; i < m; i++)
  {
    int a, b;
    cin >> a >> b;
    v[a].push_back(b); //양쪽모두 연결 표시
    v[b].push_back(a);
  }

  visit[1] = 1;
  bfs(1); //시작점 1번과 연결점 0번(자기자신)

  int ans = 0;
  for (int i = 2; i <= n; i++)
  {
    if (visit[i] == 2 || visit[i] == 3)
      ans++;
  }

  cout << ans << endl;
}
