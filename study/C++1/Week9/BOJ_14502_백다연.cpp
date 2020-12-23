#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int n, m;
int arr[4][9];
int temp[4][9];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int ans = 0;

void bfs()
{
  int result[8][8];

  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
      result[i][j] = temp[i][j];
  }

  queue<pair<int, int>> q;

  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
    {
      if (result[i][j] == 2) //바이러스
        q.push(make_pair(i, j));
    }

    while(!q.empty())
    {
      int y = q.front().first;
      int x = q.front().second;
      q.pop();

      for (int i = 0; i < 4; i++)
      {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if (0 <= ny && ny < n && 0 <= nx && nx < m)
        {
          if (result[ny][nx] == 0)
          {
            result[ny][nx] = 2; //감염시키기
            q.push(make_pair(ny, nx));
          }
        }
      }
    }
    int num = 0;
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < m; j++)
      {
        if(result[i][j] == 0)
          {
            num++;
          }
      }
    }

    ans = max(ans, num);
  }

void Wall(int cnt){
    if (cnt == 3)
    {
      bfs();
      return;
    }

    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
      {
        if (temp[i][j] == 0)
        {
          temp[i][j] = 1;
          wall(++cnt);
          temp[i][j] = 0;
        }
      }
  }

  int main()
  {
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < m; j++)
      {
        cin >> arr[i][j];
      }
    }

    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < m; j++)
      {

        if (arr[i][j] == 0)
        {
          for (int s = 0; s < n; s++)
            for (int k = 0; k < m; k++)
              temp[s][k] = arr[s][k]; //복사

          //빈칸인 곳에 일단 벽을 세움
          temp[i][j] = 1;
          Wall(1);
          temp[i][j] = 0;
        }
      }
    }

    cout << ans << endl;
    return 0;
  }
