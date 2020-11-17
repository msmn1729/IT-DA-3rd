#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	vector<pair<int, int>> v;
	vector<string> str;
	string s;

	int ABC[26] = { 0, };
	int T; cin >> T;
	for (T; T > 0; T--)
	{
		cin >> s;
		str.push_back(s);
		for (int i = 0; i < s.length(); i++)
		{
			ABC[s[i] - 'A'] += pow(10.0, s.length() -1 - i);
		}
	}
	for (int i = 0; i < 26; i++)
	{
		//cout << ABC[i] << endl;
		if (ABC[i] == 0) continue;
		v.push_back({ ABC[i],i });
	}
	sort(v.begin(), v.end());
	reverse(v.begin(), v.end());

	int max = 9;
	for (int i = 0; i < v.size(); i++)
	{
		ABC[v[i].second] = max--;
	}
	int sum = 0;
	for (int i = 0; i < str.size(); i++)
	{
		int temp = 0;
		for (int j = 0; j < str[i].length(); j++)
		{
			temp *= 10;
			temp += ABC[str[i][j] - 'A'];
		}
		sum += temp;
	}
	cout << sum;

	return 0;
}
