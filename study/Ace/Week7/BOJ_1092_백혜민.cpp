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
			for (int j = 0; j < c.size(); j++)
			{
				/*
				for (int i = 0; i < cargo.size(); i++)
					cout << cargo[i] << " ";
				cout << endl;
				*/
				if (cargo.empty()) break;
				if (cargo.front() <= c[j])
				{
					cargo.erase(cargo.begin());
				}
				else
				{
					for (int i = 1; i < cargo.size(); i++)
					{
						if (cargo[i] <= c[j])
						{
							cargo.erase(cargo.begin() + i); break;
						}
					}
					/*
					if (lower_bound(cargo.begin(), cargo.end(), c[j]) == cargo.end())
						break;

					int idx = lower_bound(cargo.begin(), cargo.end(), c[j]) - cargo.begin();
					cargo.erase(cargo.begin() + idx);
					*/
				}
			}
			minute++;
		}
	}
	cout << minute;

	return 0;
}
