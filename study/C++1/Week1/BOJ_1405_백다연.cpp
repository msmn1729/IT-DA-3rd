#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
#include <iomanip> //소수점
using namespace std;

//미친로봇
//같은곳을 또다시 방문하지 않아야 단순

int N;
int arr[30][30];
int visit[30][30];
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0}; //동서남북 맞춰야함..
double dir[4];
double ans;

void dfs(int x, int y, int count, double per)
{
  if (count == N) //N번만큼 이동하면
  {
    ans += per;
    return;
  }
  visit[x][y] = true;
  for (int i = 0; i < 4; i++)
  {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (!visit[nx][ny])
    {
      dfs(nx, ny, count + 1, per * dir[i]);
    }
  }
  visit[x][y] = false; //방문한곳 다시 false로
}

int main()
{
  cin >> N;
  for (int i = 0; i < 4; i++)
  {
    cin >> dir[i];
    dir[i] /= 100; //소수로 만들어서 저장
  }
  dfs(15, 15, 0, 1.0);

  cout << fixed << endl; //소수점 고정
  cout.precision(10);    //소수점 10
  cout << ans << endl;

  return 0;
}
