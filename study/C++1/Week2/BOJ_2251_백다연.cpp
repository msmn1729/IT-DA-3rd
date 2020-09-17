#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

//앞 물통은 비어있고 마지막 물통가득
//한 물통이 비거나 다른 한 물통이 가득찰 때
//첫번째 물통이 비어있다면 세번째 물통에 담겨있을 수 있는 물의양

int a, b, c;
int ans[201];
int visit[201][201];
struct Water
{
  int a;
  int b;
  int c;
};

void bfs()
{
  queue<Water> q;

  q.push({0, 0, c});

  while (!q.empty())
  {

    Water now = q.front();
    q.pop();

    if (visit[now.a][now.b])
      continue;
    visit[now.a][now.b] = true;

    //a가 빈칸이라면 true 저장
    if (now.a == 0)
      ans[now.c] = true;

    //a에서 b로 옮기는 경우
    if (now.a + now.b > b)
      q.push({(now.a + now.b) - b, b, now.c});
    else
      q.push({0, now.a + now.b, now.c});

    //a에서 c로 옮기는 경우
    if (now.a + now.c > c)
      q.push({(now.a + now.b) - c, now.b, c});
    else
      q.push({0, now.b, now.a + now.c});
    //b에서 c
    if (now.b + now.c > c)
      q.push({now.a, (now.b + now.c) - c, c});
    else
      q.push({now.a, 0, now.b + now.c});
    //b에서 a
    if (now.b + now.a > a)
      q.push({a, (now.b + now.a) - a, now.c});
    else
      q.push({now.b + now.a, 0, now.c});
    //c에서 a
    if (now.c + now.a > a)
      q.push({a, now.b, (now.c + now.a) - a});

    else
      q.push({now.c + now.a, now.b, 0});

    //c에서 b
    if (now.c + now.b > b)
      q.push({now.a, b, (now.c + now.b) - b});

    else
      q.push({now.a, now.c + now.b, 0});
  }
}

int main()
{
  cin >> a >> b >> c;
  bfs();
  for (int i = 0; i <= c; i++)
  {
    if (ans[i])
      cout << i << endl;
  }

  return 0;
}
