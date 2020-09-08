#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>
#include <iomanip> //소수점
using namespace std;

//말은 체스와 나이트 같이 이동, 원송이는 k번만 말같이 이동하고 나머지는 인접한 곳 이동 가능
//맨 왼쪽에서 맨오른쪽 아래까지 최소한의 동작으로 이동해야함.
//0은평지 1은 장애물

int K,w,h;
int arr[200][200];
int visit[200][200][32];

//일반 이동
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};
//나이트 이동
int ky[8] = {-1, -2, -2, -1, 2, 1, 2, 1};
int kx[8] = {-2, -1, 1, 2, 1, 2, -1, -2};

int bfs(int y, int x)
{
  queue <pair<pair<int,int>,pair<int,int>>> q; //x,y / k,cnt
  q.push(make_pair(make_pair(y,x), make_pair(0,0)));
  visit[y][x][0] = true;

  while(!q.empty())
  {
    int cury = q.front().first.first;
    int curx = q.front().first.second;
    int kdir = q.front().second.first;
    int cnt = q.front().second.second;

    q.pop();

    //도착지에 도달하면
    if(cury == h-1 && curx == w-1)
      return cnt;
    
    //아직 말처럼 이동할 수 있을 때
    if(kdir < K)
    {
      for(int i = 0; i < 8; i++)
      {
        int nx = curx + kx[i];
        int ny = cury + ky[i];

        if(0<=ny && ny < h && 0 <= nx && nx < w)
          if(!visit[ny][nx][kdir+1] && !arr[ny][nx]) //방문하지 않고 장애물이 아니라면
          {
            visit[ny][nx][kdir+1] = true; //k번 이동하였으므로 +1
            q.push(make_pair(make_pair(ny,nx),make_pair(kdir+1,cnt+1)));
          }
      }
    }
      //나이트 이동 안할때
      for(int i = 0; i < 4; i++)
      {
        int nx = curx + dx[i];
        int ny = cury + dy[i];

        if (0 <= ny && ny < h && 0 <= nx && nx < w)
          if(!visit[ny][nx][kdir] && !arr[ny][nx])
          {
            visit[ny][nx][kdir] = true;
            //k이동 아니므로 cnt만 +1
            q.push(make_pair(make_pair(ny,nx), make_pair(kdir, cnt+1)));
          }
      }

    
  }
  return -1;
}


int main()
{
  cin >> K;
  cin >> w >> h;

  for(int i = 0; i < h; i++)
    for(int j = 0; j < w; j++)
    {
      cin >> arr[i][j];
    }

   cout << bfs(0,0) << endl;

   return 0;
}