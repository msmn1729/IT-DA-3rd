#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>

using namespace std;

int main(void)
{
    int T, N, L;
    int diff;   
    vector<int> wood[10000]; 
    int tmp[10000] = {0, };

    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> N;
        for (int j = 0; j < N; j++) {
            cin >> L;
            wood[i].push_back(L);
        }
        sort(wood[i].begin(), wood[i].end());

        for (int j = 0; j < N; j++) {
            if (j % 2 == 0) { // 홀수번째면 앞으로
                tmp[j / 2] = wood[i][j];
            } 
            else { // 짝수번째면 뒤로
                tmp[N - 1 - (j / 2)] = wood[i][j];
            }
        }

        diff = abs(tmp[0] - tmp[N - 1]);
        for (int j = 0; j < N - 1; j++) {
            diff = diff >= abs(tmp[j] - tmp[j + 1]) ? diff : abs(tmp[j] - tmp[j + 1]);
        }
        cout << diff << endl;
    }

    return 0;
}