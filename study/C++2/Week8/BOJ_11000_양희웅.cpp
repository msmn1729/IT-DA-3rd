#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N;
pair<int, int> classtime[200000];
priority_queue<int, vector<int>, greater<int> > pq;

bool increase(pair<int, int> a, pair<int, int> b)
{
    return a.first < b.first;
}

void solve(void)
{
    pq.push(classtime[0].second);
 
	for (int i = 1; i < N; i++) {
		if (pq.top() <= classtime[i].first) {
			pq.pop();
			pq.push(classtime[i].second);
		}
		else {
			pq.push(classtime[i].second);
		}
	}
 
	cout << pq.size() << endl;
}

void input(void)
{
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> classtime[i].first >> classtime[i].second;
    }
    sort(classtime, classtime + N, increase);
}

int main(void)
{
    input();
    solve();

    return 0;
}