#include <bits/stdc++.h>
using namespace std;
double dir[4];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
double per_sum = 0;
int check[26][26];
double per[26][26];

void dfs(int n, int x, int y) {
    // n만큼의 횟수를 더한뒤 확률을 누적해서 더한다
    if (n == 0) {
        per_sum += per[y][x];
        return;
    }
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (check[ny][nx] == false) {
            per[ny][nx] = per[y][x] * dir[i];
            check[ny][nx] = true;
            dfs(n - 1, nx, ny);
            check[ny][nx] = false;
        }
    }
}
// 이 문제에서는 동서남북 갈 확률이 모두 다를수 있으므로 케이스/전체를 해주면 안된다
int main() {
    int n;
    cin >> n;
    int E, W, S, N;
    //이 문제에서 요구하는 각 방향별 확률을 저장하기 위해서
    for (int i = 0; i < 4; i++) {
        int k;
        cin >> k;
        dir[i] = (double)k / 100;
    }
    per[14][14] = 1;
    // 시작점 항상 true
    check[14][14] = true;
    dfs(n, 14, 14);
    //소수점을 고정하는 코드라고 한다(?)
    cout.precision(11);
    cout.fixed;
    cout << per_sum;
    return 0;
}