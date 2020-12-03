#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int answer, N, K;
bool abc[26];
vector<string> sub;

void recur(int idx, int size)
{
	if (size == K-5)
	{
		int n = 0;
		for (int i = 0; i < sub.size(); i++)
		{
			bool flag = false;
			for (int j = 0; j < sub[i].length(); j++)
			{
				if (!abc[sub[i][j]-'a'])
				{
					flag = true; break;
				}
			}
			if (!flag)
				n++;
		}
		answer = (answer < n) ? n : answer;
	}
	else
	{
		for (int i = idx; i < 26; i++)
		{
			if (!abc[i])
			{
				abc[i] = true;
				recur(i, size + 1);
				abc[i] = false;
			}
		}
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	abc[0] = 1, abc[2] = 1, abc['i' - 'a'] = 1, abc['n' - 'a'] = 1, abc['t' - 'a'] = 1;

	cin >> N >> K;
	if (K < 5)
	{
		cout << 0; return 0;
	}
	else if (K == 26)
	{
		cout << N; return 0;
	}
	for (int i = 0; i < N; i++)
	{
		string s; cin >> s;
		string temp = "";
		for (int j = 4; j <= s.length() - 5; j++)
			temp += s[j];

		sub.push_back(temp);
	}

	recur(0, 0);
	cout << answer;

	return 0;
}
