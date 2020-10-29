#include <iostream>

using namespace std;

typedef struct
{
    int r;
    int c;
} dot;

int N, M;
int K; //동그라미의 위치
dot circle;
long long factorial[16] {};

long long getFactorial(int num)
{
    if (num == 1) {
        factorial[num] = 1;
        return 1;
    }
    if (factorial[num] != 0) {
        return factorial[num];
    }
    factorial[num] = (long long)num * getFactorial(num - 1);
    return factorial[num];
}

long long getRoute(dot start, dot end)
{
    int row = end.r - start.r;
    int column = end.c - start.c;
    long long numofRoute = (long long)(getFactorial(row + column) / (getFactorial(row) * getFactorial(column)));
    return numofRoute;
}

void solve()
{
    if (K == 0) {
        cout << getRoute(dot{0, 0}, dot{N - 1, M - 1}) << endl;
    }
    else if ((circle.r == 0 && circle.c == M - 1) || (circle.r == N - 1 && circle.c == 0)) {
        cout << 1 << endl;
    }
    else if (circle.r == 0 || circle.c == 0) {
        cout << getRoute(circle, dot{N - 1, M - 1}) << endl;
    }
    else {
        int route1 = getRoute(dot{0, 0}, circle);
        int route2 = getRoute(circle, dot{N - 1, M - 1});
        cout << route1 * route2 << endl;
    }
}

void input()
{
    cin >> N >> M >> K;
    if (K != 0) {
        circle.r = (int)((K - 1) / 5);
        if (circle.r == 0) {
            circle.c = K - 1;
        }
        else {
            circle.c = K - circle.r * 5 - 1;
        }
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}