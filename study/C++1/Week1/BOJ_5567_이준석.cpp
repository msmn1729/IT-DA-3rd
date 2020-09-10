#include <iostream>
#include <queue>
using namespace std;
vector<int> arr[501];
int col[501] = { 0 };
int main() {
	int n, m, a, b, result=0;
	cin >> n >> m;
	for (int i = 0; i < m; i++)
	{
		cin >> a >> b;
		arr[a].push_back(b);
		arr[b].push_back(a);
	}
	queue<pair<int,int>> q;
	q.push(make_pair(1,0));
	col[1] = 1;
	while (!q.empty())
	{
		int x = q.front().first;
		int cnt = q.front().second;
		q.pop();
		if (cnt > 1)
			break;
		else {
			for (int i = 0; i < arr[x].size(); i++)
			{
				if (col[arr[x][i]] == 0)
				{
					q.push(make_pair(arr[x][i], cnt+1));
					col[arr[x][i]] = 1;
					result ++;
				}
			}
		}
	}
	cout << result;
}