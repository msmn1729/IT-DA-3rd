#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int d[1500001];
int main() {
    vector<pair<int, int>> v;
    int N;
    cin >> N;
    v.push_back(make_pair(0, 0));
    for (int i = 1; i <= N; i++) {
        int x, y;
        cin >> x >> y;
        v.push_back(make_pair(x, y));
    }
    for (int i = 1; i <= N; i++) {
        d[i + v[i].first] = max(d[i + v[i].first], d[i] + v[i].second);
        d[i+1]=max(d[i],d[i+1]);
    }
    printf("%d\n", d[N+1]);
    



}