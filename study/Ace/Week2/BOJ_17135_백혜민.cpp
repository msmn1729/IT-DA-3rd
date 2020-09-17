#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cmath>
#include <cstring>
using namespace std;

int n, m, d, answer;
int map[15][15]; int clone[15][15];
vector<int> tmp; vector<int> goong;

void down()
{

}
void kill(int a, int b, int c)
{
	int shoot = 0;
	for (int i = 0; i < n; i++)
	{

	}
}
void com()
{
	for (int i = 0; i < m; i++)
		tmp.push_back(i);
	for (int i = 0; i < 3; i++)
		goong.push_back(1);
	for (int i = 0; i < m - 3; i++)
		goong.push_back(0);
	sort(goong.begin(), goong.end());
	do
	{
		vector<int> arr;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
				clone[i][j] = map[i][j];
		}
		for (int i = 0; i < goong.size(); i++)
		{
			if (goong[i] == 1)
				arr.push_back(tmp[i]);
		}
		kill(arr[0], arr[1], arr[2]);
	} while (next_permutation(goong.begin(), goong.end()));
}
void init()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m >> d;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cin >> map[i][j];
	}
}
int main()
{
	init();
	com();

	return 0;
}
