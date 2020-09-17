#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int visited[99999999] = { 0, };

int n;

vector <int> v;

bool function(int num)
{
	if (num <= 1) return false;
	int half = num / 2;
	for (int i = 2; i < half; i++)
	{
		if (num % i == 0)
			return false;
	}
	return true;
}

void dfs(int num, int digit)
{
	if (function(num))		//소수이면
	{
		if (digit == n)
		{
			v.push_back(num);
			return;
		}

		for (int i = 0; i < 9; i++)
		{
			if (visited[num * 10 + i] == 0)
			{
				visited[num * 10 + i] = 1;
				dfs(num * 10 + i, digit + 1);
			}
		}
	}
	else
	{
		while (num++ % 10 != 9)
		{
			if (visited[num] == 0)
			{
				visited[num] = 1;
				dfs(num, digit);
			}
		}

	}

}

int main()
{
	cin >> n;

	dfs(1, 1);

	sort(v.begin(), v.end());
	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << endl;
	}
}