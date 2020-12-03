#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#include <queue>
using namespace std;
vector<int>result;
int main() {
	int t;
	cin >> t;
	while(t--)
	{
		vector <pair <int, int>> vec;
		vector <int> col;
		int x1, y1, x2, y2,n,ans=0;
		cin >> n >> x1 >> y1;
		vec.push_back(make_pair(x1, y1));
		col.push_back(0);
		for (int i = 0; i < n; i++)
		{
			int x3, y3;
			vec.push_back(make_pair(x3, y3));
			col.push_back(0);
		}
		
		cin >> x2 >> y2;
		vec.push_back(make_pair(x2, y2));
		col.push_back(0);
		queue <pair <int, int>> q;
		q.push(vec[0]);
		while (!q.empty())
		{
			int a = q.front().first;
			int b = q.front().second;
			if (a == x2 && b == y2)
			{
				ans = 1;
				break;
			}
			q.pop();
			for (int i = 1; i <= n+1; i++)
			{
				if (col[i] == 0 && abs(vec[i].first-a)+abs(vec[i].second-b) <= 1000)
				{
					q.push(vec[i]);
					col[i] = 1;
				}
			}
		}
		result.push_back(ans);
	}
	for (int i = 0; i < result.size(); i++) {
		if (result[i] == 1)
			cout << "happy"<<endl;
		else
			cout << "sad";

	}
}