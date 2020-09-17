#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
using namespace std;

//그림의 넓이는 그림에 포함된 1의 개수
//상하좌우만 가능

int n,m;
int arr[501][501];
int visit[501][501];
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
int bigsize = 0; //넓이를 저장

int value = 0;

void dfs(int y, int x)
{
  bigsize++;
  visit[y][x] = true;
  for(int i = 0; i < 4; i++)
  {
    int ny = y + dy[i];
    int nx = x + dx[i];
    
    if(0<=ny && ny < n && 0<=nx && nx<m)
      if(!visit[ny][nx] && arr[ny][nx])
        {
          dfs(ny, nx);
        }
  }
      
}

int main()
{
  cin >> n >> m;
  for(int i = 0; i < n; i++)
  {
    for(int j = 0; j < m; j++)
    {
        cin >> arr[i][j];
    }
  }

  int cnt = 0;
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
    {
      if(!visit[i][j] && arr[i][j]) {
          bigsize = 0;
          dfs(i,j);
          value = max(value, bigsize);
          cnt++;
      }
    }
  }

  cout << cnt << endl;
  cout << value << endl;

  return 0;
}
