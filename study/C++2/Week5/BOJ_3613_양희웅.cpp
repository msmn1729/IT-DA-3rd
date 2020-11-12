#include <iostream>
#include <cstring>

/*
    파이썬 쓰고싶다
    갓갓 파이썬
    파이썬은 정말 편하게 쓰겠지
    파이썬은 아름답고 우아하게 짜겠지
*/

/*
    'A' ~ 'Z' = 65 ~ 90
    'a' ~ 'z' = 97 ~ 122
    '_' = 95
*/

/*
    문제가 너무 더럽다
*/

using namespace std;

char target[101];
bool java, cpp;

void solve()
{
    char* pos = &target[1];

    // 첫번째부터 대문자, '_'이거나 마지막이 '_'면 error
    if (target[0] >= 65 && target[0] <= 90 || target[0] == 95 || target[strlen(target) - 1] == 95) {
        cout << "Error!" << endl;
        return;
    }

    // java하고 c++이 섞여있고 '_'이 연속되면 error
    for (int i = 1; i < strlen(target); i++) {
        if (target[i] == 95) {
            if (cpp || target[i - 1] == 95) {
                cout << "Error!" << endl;
                return;
            }
            java = true;
        }
        else if (target[i] >= 65 && target[i] <= 90) {
            if (java) {
                cout << "Error!" << endl;
                return;
            }
            cpp = true;
        } 
    }

    cout << target[0];
    while (*pos != 0) {
        if (*pos == 95) { // java
            pos++;
            cout << (char)(*pos - 32); // 소문자 -> 대문자
            pos++;
            continue;
        }
        else if (*pos >= 65 && *pos <= 90) { // C++ 
            cout << '_';
            cout << (char)(*pos + 32); // 대문자 -> 소문자
            pos++;
            continue;
        }
        cout << (char)*pos;
        pos++;
    }
    cout << endl;
}

void input()
{
    cin >> target;
}

int main(void)
{
    input();
    solve();

    return 0;
}