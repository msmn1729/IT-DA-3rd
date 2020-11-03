#include <iostream>

using namespace std;

int T; // 테스트 케이스의 수
int N, M; // N: 국가의 수, M: 비행기의 종류
int a, b;
int country[100] {};

void solve()
{
    for (int i = 0; i < T; i++) {
        cout << country[i] << endl;
    }
}

void input()
{
    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> N >> M;
        country[i] = N - 1;
        for (int j = 0; j < M; j++) {
            cin >> a >> b;
        }
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}