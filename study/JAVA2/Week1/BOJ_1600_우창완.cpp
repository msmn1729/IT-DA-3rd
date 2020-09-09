#include <bits/stdc++.h>
using namespace std;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int hx[8] = {2, 1, -1, -2, -2, -1, 1, 2};
int hy[8] = {1, 2, 2, 1, -1, -2, -2, -1};
//visit[a][b]가 몇번째 방문하는지 체크하는 배열, 예외 처리를 완전히 해주려면 bool 배열을 하나 더 생성해서
//시작점에 대한 true처리 필요
int map_count[201][201];
int visit[201][201][31];
int W, H, K;
//queue에는 x좌표 y좌표, jump횟수가 들어간다
struct monkey {
    int x, y, jump;
};

int bfs() {
    queue<monkey> q;
    q.push({0, 0, 0});
    memset(visit, 0, sizeof(visit));

    while (!q.empty()) {
        int x = q.front().x;
        int y = q.front().y;
        int jump = q.front().jump;
        q.pop();
        if (x == W - 1 && y == H - 1) {
            return visit[y][x][jump];
        }
        //점프 횟수가 있을 때 점프이동
        if (K > jump) {
            for (int i = 0; i < 8; i++) {
                int nx = x + hx[i];
                int ny = y + hy[i];
                if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                    if (map_count[ny][nx] == 0 && visit[ny][nx][jump + 1] == 0) {
                        q.push({nx, ny, jump + 1});
                        visit[ny][nx][jump + 1] = visit[y][x][jump] + 1;
                    }
                }
            }
        }
        // 상하좌우 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                if (map_count[ny][nx] == 0 && visit[ny][nx][jump] == 0) {
                    q.push({nx, ny, jump});
                    visit[ny][nx][jump] = visit[y][x][jump] + 1;
                }
            }
        }
    }
    return -1;
}
int main() {
    // W가로 H세로
    cin >> K >> W >> H;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            cin >> map_count[i][j];
        }
    }
    //bfs 를 탐색을 한뒤 탐색에 성공하면 값, 탐색에 실패하면 -1 출력
    cout << bfs();
    return 0;
}