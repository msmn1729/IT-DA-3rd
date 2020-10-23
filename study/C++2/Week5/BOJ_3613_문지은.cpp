#include <iostream>
#include <string>
using namespace std;

int main()
{
	string s;
	cin >> s;

	string ans = "";

	bool c = false;
	bool java = false;
	int i = 0;

	while (s[i] != '\0')
	{
		if (s[i] == '_')
		{
			c = true;
			break;
		}
		else if ((int)s[i] >= (int)'A' && (int)s[i] <= (int)'Z')
		{
			java = true;
			break;
		}
		i++;
	}

	if (!c && !java)
	{
		cout << "Error!" << endl;
		return 0;
	}

	else if (c)
	{
		int i = 1;
		ans += s[0];
		while (s[i] != '\0')
		{
			if (s[i] == '_')
			{
				i++;
				continue;
			}
			else if (s[i - 1] == '_')
				ans += s[i] + (int)('A' - 'a');
			else
				ans += s[i];

			i++;

		}
		cout << ans << endl;
		return 0;
	}

	else if (java)
	{
		int i = 0;
		string sans = "";
		while (s[i] != '\0')
		{
			if ((int)s[i] >= (int)'A' && (int)s[i] <= (int)'Z')
			{
				ans += '_';
				ans += s[i] - (int)('A' - 'a');
			}
			else
				ans += s[i];
			
			i++;

		}
		cout << ans << endl;
		return 0;

	}
}
