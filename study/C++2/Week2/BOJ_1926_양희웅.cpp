#include <iostream>
#include <queue>

using namespace std;

typedef struct
{
    int row;
    int column;
} dot;

int dr[] = {0, 0, -1, 1};
int dc[] = {1, -1, 0, 0};
int n, m;
int graph[500][500] = {-1, };
bool check[500][500] = {false, };
int pictureNum;
int picture[250 * 500] = {0, };

int bfs(dot start)
{
    queue<dot> q;
    q.push(start);
    check[start.row][start.column] = true;
    int pictureSize = 1;

    while (!q.empty()) {
        dot next = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nextr = next.row + dr[i];
            int nextc = next.column + dc[i];
            if (!(graph[nextr][nextc] == 1 && nextr >= 0 && nextr < n && nextc >= 0 && nextc < m)) {
                continue;
            }
            if (check[nextr][nextc] == false) {
                q.push({nextr, nextc});
                check[nextr][nextc] = true;
                pictureSize++;
            }
        }
    }
    pictureNum++;
    
    return pictureSize;
}

void solve()
{
    int bigpictureSize = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (check[i][j] == false && graph[i][j] == 1) {
                picture[pictureNum] = bfs({i, j});
            }
        }
    }

    for (int i = 0; i < pictureNum; i++) {
        if (picture[i] > bigpictureSize) {
            bigpictureSize = picture[i];
        }
    }

    cout << pictureNum << endl;
    cout << bigpictureSize << endl;
}

void input()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> graph[i][j];
        }
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}