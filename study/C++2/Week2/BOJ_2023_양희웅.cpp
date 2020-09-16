#include <iostream>

using namespace std;

int N;

bool isPrimeNumber(int num)
{
    if (num < 2)
        return false;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return false;
    }

    return true;
}

void dfs(int number, int digit)
{
    if (digit == N) {
        cout << number << endl;
    }
    for (int i = 1; i < 10; i += 2) {
        if (isPrimeNumber(number * 10 + i)) {
            dfs(number * 10 + i, digit + 1);
        }
    }
}

void solve()
{
    int start[4] = {2, 3, 5, 7};
    for (int i = 0; i < 4; i++) {
        dfs(start[i], 1);
    }
}

void input()
{
    cin >> N;
}


int main(void)
{
    input();
    solve();

    return 0;
}