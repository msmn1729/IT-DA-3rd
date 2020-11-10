#include <iostream>
#include <vector>

using namespace std;

vector<int> tree[100001];

int main(void)
{
    int N, q, t, k;
    int a, b;

    cin >> N;
    for (int i = 0; i < N - 1; i++) {
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    cin >> q;
    for (int i = 0; i < q; i++) {
        cin >> t >> k;
        if (t == 1) {
            if (tree[k].size() > 1) { // 연결된 점이 2개 이상이면 단절점
                cout << "yes" << endl;
            }
            else {
                cout << "no" << endl;
            }
        }
        else if (t == 2) { // 트리에서는 모든 선이 단절선
            cout << "yes" << endl;
        }
    }

    return 0;
}