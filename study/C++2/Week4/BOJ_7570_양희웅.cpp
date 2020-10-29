#include <iostream>

#define MAX(x,y)    ((x)>(y)?(x):(y))

using namespace std;

typedef struct
{
    int curNum;
    int len;
} chunk;

int N;
int arr[1000000] {};
chunk check[1000000] = {(0, 0), };
int CN = 1; // Chunk Num

/*
    1 4 2 3 5 -> 1 2 3 5 4 -> 1 2 3 4 5
    5 4 1 2 3 -> 5 1 2 3 4 -> 1 2 3 4 5
    4 1 5 2 3 -> 1 5 2 3 4 -> 1 2 3 4 5
    4 1 2 3 5 -> 1 2 3 5 4 -> 1 2 3 4 5
    4 5 1 2 3 -> 5 1 2 3 4 -> 1 2 3 4 5
    => 1씩 증가하는 가장 큰 덩어리를 찾는다!
*/

void solve()
{
    check[0].curNum = arr[0];

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < CN; j++) {
            if (check[j].curNum == arr[i] - 1) {
                cout << "find" << endl;
                check[j].curNum = arr[i];
                if (check[j].len == 0) {
                    check[j].len = 2;
                }
                else {
                    check[j].len++;
                }
            }
            else {
                CN++;
                cout << "else" << endl;
                check[CN - 1].curNum = arr[i];
                break;
            }
        }
    }
    
    int ML = 0; // Max Len
    for (int i = 0; i < CN; i++) {
        ML = MAX(ML, check[i].len);
    }

    cout << N - ML << endl;
}

void input()
{
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}