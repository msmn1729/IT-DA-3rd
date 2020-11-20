#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>
#include <string>
#include <map>
#include <iomanip>
#include <list>
#include <stack>
#include <cstring>
#include <cmath>
#include <set>
#define ll long long

using namespace std;

//https://www.acmicpc.net/problem/1946 신입 사원

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int t, i, n;
    cin >> t;
    
    while(t--)
    {
        cin >> n;
        vector<pair<int, int> > v;
        for(i=0; i<n; i++)
        {
            int a, b;
            cin >> a >> b;
            v.push_back({a, b});
        }
        sort(v.begin(), v.end());
        
        int min_score = v.front().second;
        int ans = 1;
        for(i=1; i<n; i++)
        {
            if(min_score > v[i].second)
            {
                ans++;
                min_score = v[i].second;
            }
        }
        cout << ans << '\n';
    }
    return 0;
}
