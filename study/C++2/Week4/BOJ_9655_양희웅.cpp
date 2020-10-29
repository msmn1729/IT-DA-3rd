#include <iostream>

using namespace std;

int N;
/*
    오잉????????
*/
bool game(int numStone) // 상근이가 이기면 true, 창영이가 이기면 false
{
    if (numStone % 2 == 0) {
        return false;
    }
    return true;
}

void solve()
{
    if (game(N)) {
        cout << "SK" << endl;
    }
    else {
        cout << "CY" << endl;
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