#include <iostream>

using namespace std;

int N, M, K;
int money[100000] {};

bool BS(int mid)
{
    int withdraw = 1;
    int left = mid;

    for (int i = 0; i < N; i++) {
        if (mid < money[i]) {
            return false;
        }

        if (left < money[i]) {
            left = mid;
            withdraw++;
        }
        left -= money[i];
    }

    return M >= withdraw;    
}

int main(void)
{
    int low = 1;
    int high = 1000000000;
    int mid;
    int result = 0;

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> money[i];
    }

    while (low <= high) {
        mid = (low + high) / 2;

        if (BS(mid)) {
            result = mid;
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }
    cout << result << endl;

    return 0;
}