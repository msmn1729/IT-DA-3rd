#include <iostream>
#include <vector>
#include <cmath>
#include <cstring>
using namespace std;

int N;
bool visited[9][10];

bool isPrime(int x)
{
	bool flag = true;
	for (int i = 2; i <= sqrt(x); i++)
	{
		if (x%i == 0)
		{
			flag = false; break;
		}
	}
	return flag;
}
void dfs(int x, int num)
{
	if (num == N)
	{
		if (isPrime(x))
			cout << x << "\n";
		return;
	}
	for (int i = 0; i < 10; i++)
	{
		if (!visited[num][i])
		{
			if (isPrime(x * 10 + i))
			{
				visited[num][i] = true;
				dfs(x * 10 + i, num + 1);
				visited[num][i] = false;
			}
		}
	}
}
void init()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;
}
int main()
{
	init();
	dfs(2, 1); dfs(3, 1); dfs(5, 1); dfs(7, 1);

	return 0;
}