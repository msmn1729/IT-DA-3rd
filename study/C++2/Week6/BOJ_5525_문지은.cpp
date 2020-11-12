#include <iostream>
#include <string>
using namespace std;

int main()
{
	int n, m;
	string s;

	cin >> n >> m;
	cin >> s;

	int cnt = 0;
	int tcnt = 0;
	int len = m - 2;
	for (int i = 0; i < len; i++)
	{
		if (s[i] == 'I' && s[i + 1] == 'O' && s[i + 2] == 'I')
		{
			tcnt++;
			if (tcnt == n)
			{
				cnt++;
				tcnt--;
			}
			i++;
		}
		else
			tcnt = 0;
	}

	cout << cnt;

}