#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool find(string a, string b)
{
	for (int i = 0; i < b.length(); i+=a.length())
	{
		if (i + a.length()<b.length())
		{
			string temp = b.substr(i, a.length());
			if (temp == a)
				return false;
		}
	}
	return true;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int t; cin >> t;
	for (int i = 0; i < t; i++)
	{
		int n; cin >> n;
		string* arr = new string[n];
		for (int j = 0; j < n; j++)
			cin >> arr[j];

		sort(arr, arr + n);
		
		bool flag = true;
		for (int j = 0; j < n-1; j++)
		{
			if (arr[j].length() < arr[j+1].length())
			{
				if (!find(arr[j], arr[j+1]))
				{
					//cout << arr[j] << " " << arr[k] << endl;
					flag = false; break;
				}
			}
		}
		if (flag) cout << "YES\n";
		else cout << "NO\n";
	}

	return 0;
}
