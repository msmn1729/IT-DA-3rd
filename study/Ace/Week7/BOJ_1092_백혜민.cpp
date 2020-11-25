#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N; cin >> N;
	vector<int> c;
	for (int i = 0; i < N; i++)
	{
		int x; cin >> x;
		c.push_back(x);
	}

	int M; cin >> M;
	vector<int> cargo;
	for (int i = 0; i < M; i++)
	{
		int x; cin >> x;
		cargo.push_back(x);
	}

	sort(c.begin(), c.end());
	reverse(c.begin(), c.end());
	sort(cargo.begin(), cargo.end());
	reverse(cargo.begin(), cargo.end());

	int minute = 0;

	if (c[0] < cargo[0])
	{
		cout << -1;
	}
	else
	{
		while (!cargo.empty())
		{
			for(int i =0;i<c.size();i++)
			{ 
				for (int j = 0; j < cargo.size(); j++)
				{
					if (cargo[j] <= c[i])
					{
						cargo.erase(cargo.begin() + j);
						break;
					}
				}
			}
			minute++;
		}
	}
	cout << minute;

	return 0;
}
