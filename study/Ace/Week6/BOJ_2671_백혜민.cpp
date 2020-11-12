#include <iostream>
#include <string>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	string s; cin >> s;

	int flag = 0, idx = 0;
	if (s.substr(0, 3) == "100") 
	{
		flag = 0; idx = 3;
	}
	else if (s.substr(0, 2) == "01") flag = 2;
	else
	{
		cout << "NOISE"; return 0;
	}
	for (int i = idx; i < s.length(); i++)
	{
		if (flag == 0)
		{
			if (s[i] == '1')
			{
				flag = 1;
			}
		}
		else if (flag == 1)
		{
			if (s[i] == '0')
			{
				if (s.substr(i, 2) == "01")
				{
					i++; flag = 2;
				}
				else
				{
					cout << "NOISE"; return 0;
				}
			}
			else
			{
				if (s.substr(i, 3) == "100")
				{
					i += 2; flag = 0;
				}
			}
		}
		else
		{
			if (s.substr(i, 2) == "01")
			{
				i++;
			}
			else if (s.substr(i, 3) == "100")
			{
				i += 2; flag = 0;
			}
			else
			{
				cout << "NOISE"; return 0;
			}
		}
	}
	cout << "SUBMARINE";

	return 0;
}
