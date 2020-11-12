#include <iostream>
#include <string>
using namespace std;

bool check1(int n)		//felindrome
{
	string s = to_string(n);
	int len = s.size();
	int a = len / 2;

	for (int i = 0; i < a; i++)
	{
		if (s[i] != s[len - 1 - i])
			return false;
	}
	return true;
}

bool check2(int n)		//prime
{
	if (n == 1) return false;
	for (int i = 2; i < n; i++)
	{
		if (n%i == 0)
			return false;
	}
	return true;
}

int main()
{
	int n;
	cin >> n;

	int ans = n;

	while (1)
	{
		if (check1(ans) && check2(ans))
		{
			cout << ans;
			break;
		}
		ans++;

	}

}