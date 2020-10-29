#include <iostream>

#define MAX(x,y)    ((x)>(y)?(x):(y))

using namespace std;

/*
    N: 곡의 개수
    S: 시작 볼륨
    M: 최대 볼륨
    V: 변경할 수 있는 볼륨
*/
int N, S, M;
int V[101];
int memo[101][1000] {-1, };

int volume(int order, int curVol)
{
    if (order > N || curVol < 0 || curVol > M) {
        return -1;
    }
    if (memo[order][curVol] != -1) {
        return memo[order][curVol];
    }
    memo[order][curVol] = volume(order + 1, curVol + V[order]) + volume(order + 1, curVol - V[order]);
    
    return memo[order][curVol];
}

void solve()
{
    int MV = 0; // Max Volume

    volume(1, S);
    for (int i = 0; i < M; i++) {
        MV = MAX(MV, memo[N][i]);
    }
    cout << MV << endl;
}

/*
    3 5 10
    5 3 7

    10
*/
void input()
{
    cin >> N >> S >> M;
    for (int i = 1; i <= N; i++) {
        cin >> V[i];
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}