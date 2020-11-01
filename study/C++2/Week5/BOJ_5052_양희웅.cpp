#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int t;
int n;
vector<string> numbers[50];

void solve()
{
    int check = 1;

    for (int i = 0; i < t; i++) {
        for (int j = 1; j < numbers[i].size(); j++) {
            if (numbers[i][j-1] == numbers[i][j].substr(0, numbers[i][j-1].size())) {
                check = 0;
                break;
            }
        }
        if (check == 1) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
        check = 1;
    }
}

void input()
{
    string tmp;
    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> n;
        for (int j = 0; j < n; j++) {
            cin >> tmp;
            numbers[i].push_back(tmp);
        }
        sort(numbers[i].begin(), numbers[i].end());
    }
}

int main(void)
{
    input();
    solve();

    return 0;
}