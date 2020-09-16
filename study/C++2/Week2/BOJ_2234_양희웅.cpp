#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;

typedef struct
{
    int m;
    int n;
} dot;

int m, n; // m: row, n: column
int graph[50][50] = {0, };
bool check[50][50] = {false, };

// west, north, east, south
int dm[] = {0, -1, 0, 1};
int dn[] = {-1, 0, 1, 0};

int roomNum;
int room[2501] = {0, }; // room[roomNum] = roomSize

int bfs(dot start)
{
    queue<dot> q;
    q.push(start);
    check[start.m][start.n] = true;
    int roomSize = 1;

    while (!q.empty()) {
        dot next = q.front();
        q.pop();

        int bit = 1;
        for (int i = 0; i < 4; i++) {
            if (!(bit & graph[next.m][next.n])) {
                int nextm = next.m + dm[i];
                int nextn = next.n + dn[i];
                if (!(nextm >= 0 && nextm < m && nextn >= 0 && nextn < n)) { 
                    continue;
                }
                if (check[nextm][nextn] == false) {
                    q.push({nextm, nextn});
                    check[nextm][nextn] = true;
                    roomSize++;
                }
            }
            bit <<= 1;
        }        
    }

    return roomSize;
}

void solve()
{
    int bigRoomSize = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (check[i][j] == false) {             
                room[roomNum++] = bfs({i, j});
            }
        }
    }

    for (int i = 0; i < roomNum; i++) {
        if (room[i] > bigRoomSize) {
            bigRoomSize = room[i];
        }
    }

    cout << roomNum << endl;
    cout << bigRoomSize << endl;
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 1; k <=8; k <<= 1) {
                if ((graph[i][j] & k) == k) {
                    memset(check, false, sizeof(check));
                    graph[i][j] -= k;
                    bigRoomSize = max(bigRoomSize, bfs({i, j}));
                    graph[i][j] += k;
                }
            }
        }
    }

    cout << bigRoomSize << endl;
}

void input()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
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