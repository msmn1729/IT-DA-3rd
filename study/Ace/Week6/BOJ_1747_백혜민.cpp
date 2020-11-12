#include <iostream>
#include <string>
#include <cmath>
using namespace std;

bool isPel(string s)
{
	int idx = s.length() / 2;

	bool tf = true;
	for (int i = 0; i <= s.length() / 2; i++)
	{
		if (s[i] != s[s.length() - i - 1])
		{
			tf = false; break;
		}
	}
	if (s == "1")
		tf = false;
	return tf;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N; cin >> N;

	for (int i = N; i <= 1004000; i++)
	{
		bool tf = true;
		for (int j = 2; j <= sqrt(i); j++)
		{
			if (i%j == 0)
			{
				tf = false; break;
			}
		}
		if (i < 10)
		{
			if (i==1 || i == 4 || i == 6 || i == 8 || i == 9)
				tf = false;
		}
		if (tf)
		{
			if (isPel(to_string(i)))
			{
				cout << i; break;
			}
		}
	}
	return 0;
}
