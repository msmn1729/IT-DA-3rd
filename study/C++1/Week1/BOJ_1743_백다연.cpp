#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
using namespace std;

//음식물버리기
int arr[101][101]; //N,M 최대 크기]
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int visit[101][101] = {false};
int N, M, K;
int cnt = 1, value = 0;

void dfs(int x, int y)
{
  cnt++;
  visit[x][y] = true; //방문 한 곳

  for (int i = 0; i < 4; i++)
  {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (nx >= 0 && ny >= 0 && nx < N && ny < M)
      if (!visit[nx][ny] && arr[nx][ny])
        dfs(nx, ny);
  }
}

int main()
{

  cin >> N >> M >> K;

  int x, y;

  for (int i = 0; i < K; i++)
  {
    cin >> x >> y;
    arr[x - 1][y - 1] = true; // 음식물이 있는 곳
  }

  for (int i = 0; i < N; i++)
  {
    for (int j = 0; j < M; j++)
    {
      if (arr[i][j] && !visit[i][j]) //방문하지 않고 음식물이 있는 곳이라면
      {
        cnt = 0;
        dfs(i, j);
        if (value < cnt) //최대값
          value = cnt;
      }
    }
  }
  cout << value << endl;
}
