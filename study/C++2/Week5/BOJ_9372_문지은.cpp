#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int t;
	cin >> t;

	vector <int> ans;

	for (int i = 0; i < t; i++)
	{
		int n, m;
		cin >> n >> m;
		for (int j = 0; j < m; j++)
		{
			int a, b;
			cin >> a >> b;
		}

		ans.push_back(n - 1);
		
	}

	for (int i = 0; i < t; i++)
	{
		cout << ans[i] << endl;
	}


}
