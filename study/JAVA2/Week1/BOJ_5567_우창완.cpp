#include <bits/stdc++.h>
using namespace std;
int cnt = 0;
vector<int> depth(10001);

void bfs(int start, vector<vector<int>> g, vector<bool> &check) {
    queue<int> q;
    q.push(start);
    depth[start] = 0;
    //start노드에서 깊이가 2이상일때 continue
    check[start] = true;
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        if (depth[x] >= 2) continue;
        for (int i = 0; i < g[x].size(); i++) {
            int y = g[x][i];
            if (!check[y]) {
                q.push(y);
                check[y] = true;
                depth[y] = depth[x] + 1;
                cnt++;
            }
        }
    }
}
int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> g(n + 1);
    vector<bool> check(n + 1);
    //연결 리스트 생성
    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        g[from].push_back(to);
        g[to].push_back(from);
    }
    bfs(1, g, check);
    cout << cnt;
    return 0;
}