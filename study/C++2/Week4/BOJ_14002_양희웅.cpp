#include <iostream>

using namespace std;

int N;
int arr[1001] {};
int D[1001] {};
int V[1001] {};

void solve()
{
    for (int i = 0; i < N; i++) {
        D[i] = 1;
        V[i] = 0;
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j] && D[i] < D[j] + 1) {
                D[i] = D[j] + 1;
                V[i] = j;
            }
        }
    }

    int max = D[0];
    int maxi = 0;
    for (int i = 1; i < N; i++) {
        if (max < D[i]) {
            max = D[i];
            maxi = i;
        }
    }
    cout << max << endl;

    int ans[1001];
    for (int i = 0; i < max; i++) {
        ans[i] = arr[maxi];
        maxi = V[maxi];
    }

    for (int i = 1; i <= max; i++) {
        cout << ans[max - i] << " ";
    }
    cout << endl;
}

void input()
{
    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}