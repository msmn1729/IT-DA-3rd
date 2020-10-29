#include <iostream>

using namespace std;

int child[1000000] {};
bool memo[1000001] {false, }; // 그 숫자를 파악했는지 체크
int numChild;
/*
    연속하는 숫자의 패턴을 찾는다
    5 2 4 1 3 -> 2 3 이 연속이므로 5 4 1 만 이동하면 된다
    4 7 2 5 1 6 -> 4 5 6 이 연속이므로 7 2 1 3 만 이동하면 된다
*/
void solve()
{
    int maxPattern = 0;
    for (int i = 0; i < numChild; i++) {
        int curNum = child[i];
        int curPattern = 1;
        if (!memo[curNum]) {
            for (int j = 1; j < numChild - i; j++) {
                if (memo[child[i + j]]) {
                    continue;
                }
                if (child[i + j] == curNum + 1) {
                    curPattern++;
                    curNum++;
                    memo[child[i + j]] = true;    
                }
            }
            memo[curNum] = true; // 그 숫자 파악으로 체크
        }
        if (curPattern > 1) {
            maxPattern = maxPattern >= curPattern ? maxPattern : curPattern;
        }
    }
    cout << numChild - maxPattern << endl;
}

void input()
{
    cin >> numChild;
    for (int i = 0; i < numChild; i++) {
        cin >> child[i];
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}