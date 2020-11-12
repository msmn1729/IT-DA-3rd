#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
	int v[100000] = { 0, };
	int n;
	cin >> n;
	int a, b;
	for (int i = 0; i < n-1; i++)
	{
		cin >> a >> b;
		v[a]++;
		v[b]++;
	}

	int q;
	cin >> q;

	vector <string> ans;
	int t, k;
	for (int i = 0; i < q; i++)
	{
		cin >> t >> k;

		if (t == 1)
		{
			if (v[k] > 1) ans.push_back("yes");
			else ans.push_back("no");
		}
		else if (t == 2)
		{
			ans.push_back("yes");
		}
	}

	for (int i = 0; i < q; i++)
	{
		cout << ans[i] << endl;
	}
}