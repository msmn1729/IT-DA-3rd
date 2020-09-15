#include <iostream>
#include <queue>

using namespace std;

typedef struct
{
    int r;
    int c;
} dot;


int space[102][102] = {0, };
bool visit[102][102] = {false};
int M, N, K;
int r, c;
int dr[] = {1, -1, 0, 0};
int dc[] = {0, 0, -1, 1};
queue<dot> q;

int bfs(int startR, int startC)
{
    dot startV {startR, startC};
    int garbage = 1;

    q.push(startV);
    visit[startV.r][startV.c] = true;

    while (!q.empty()) {
        dot nextV = q.front();
        q.pop();
        for(int i = 0; i < 4; i++) {
            dot tmp;
            tmp.r = nextV.r + dr[i];
            tmp.c = nextV.c + dc[i];
            if ((tmp.r >=0 && tmp.r < N) && (tmp.c >= 0 && tmp.c < M)) {
                if (space[tmp.r][tmp.c] == 1 && visit[tmp.r][tmp.c] == false) {
                    q.push(tmp);
                    visit[tmp.r][tmp.c] = true;
                    garbage += 1;
                }
            }
        }
    }

    return garbage;
}

int main(void)
{
    int maxGarbage = 0;

    cin >> N >> M >> K;

    N -= 1;
    M -= 1;

    for (int i = 0; i < K; i++) {
        cin >> r >> c;
        space[r - 1][c - 1] = 1;
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; i < M; j++) {
            if (space[i][j] == 1) {
                if (bfs(i, j) > maxGarbage) {
                    maxGarbage = bfs(i, j);
                }
            }
        }
    }

    cout << maxGarbage << endl;

    return 0;
}