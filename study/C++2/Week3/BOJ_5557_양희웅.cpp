#include <iostream>
#include <cstring>

using namespace std;

int N;
int numbers[101] {};
long long memo[101][21];

long long equations(int depth, int num)
{
    if (depth < 0 || num < 0 || num > 20) {
        return 0;
    }
    if (depth == 1 && num == numbers[1]) { 
        return 1;
    }
    if (memo[depth][num] != (long long)-1) { // 이미 계산된 값이라면
        return memo[depth][num];
    }

    memo[depth][num] = equations(depth - 1, num - numbers[depth]) + equations(depth - 1, num + numbers[depth]);

    return memo[depth][num];
}

void solve()
{
    long long ans = equations(N - 1, numbers[N]);
    cout << ans << endl;
}

void input()
{
    cin >> N;
    memset(memo, (long long)-1, sizeof(memo)); // 계산 중간에라도 음수가 나오면 안되니 -1로 초기화
    for (int i = 1; i <= N; i++) {
        cin >> numbers[i];
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}