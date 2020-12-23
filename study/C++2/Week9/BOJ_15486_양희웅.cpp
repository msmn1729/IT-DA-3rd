#include<iostream>
 
#define MAX 1500010

using namespace std;
 
int N;
int dp[MAX];
pair<int, int> consulting[MAX]; // <기간, 금액>
 
void solve(void)
{
    int ans = 0;
    for (int i = 1; i <= N + 1; i++)
    {
        ans = ans > dp[i] ? ans : dp[i];
        if (i + consulting[i].first > N + 1) {
            continue;
        }
        
        dp[i + consulting[i].first] = ans + consulting[i].second > dp[i + consulting[i].first] ? ans + consulting[i].second : dp[i + consulting[i].first];
    }
    cout << ans << endl;
}

void input(void)
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        cin >> consulting[i].first >> consulting[i].second;
    }
}
 
int main(void)
{
    input();
    solve();
 
    return 0;
}