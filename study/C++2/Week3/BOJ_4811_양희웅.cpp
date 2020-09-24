#include <iostream>

using namespace std;

int pills[1000] {};
int numPills;
long long catalanNum[31] {};

long long catalan(int num)
{
    if (num < 2) {
        catalanNum[num] = 1;
        return 1;
    }
    if (num == 2) {
        catalanNum[num] = 2;
        return 2;
    }
    if (catalanNum[num] != 0) {
        return catalanNum[num];
    }
    for (int i = 0; i < num; i++) {
        catalanNum[num] += catalan(i) * catalan(num - 1 - i);
    }

    return catalanNum[num];
}
/*
    N개의 알약이면 모두 다 먹는데 2N일이 걸린다
    무조건 W가 N개 H도 N개
    얘네를 어떻게 배열하지??
    일단 맨 처음은 무조건 W겠고...
    카탈랑 수???????!?!?!?!??!!!!!!??!?!?!?????!?!
    직접 구해보니 잘 맞는군
    C(n) = C(0) * C(n - 1) + C(1) * C(n - 2) + ... + C(n - 1) * C(0)
*/
void solve()
{
    for (int i = 0; i < numPills; i++) {
        cout << catalan(pills[i]) << endl;
    }
}

void input()
{
    while (true) {
        cin >> pills[numPills];
        if (pills[numPills] == 0) break;
        numPills++;
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}