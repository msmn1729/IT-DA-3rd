#include <iostream>
#include <vector>
using namespace std;

vector<int> v[100001];

void init()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int N;  cin >> N;
	for (int i = 0; i < N - 1; i++)
	{
		int x, y; cin >> x >> y;
		v[x].push_back(y); v[y].push_back(x);
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	init();
	int Q; cin >> Q;
	for (int i = 0; i < Q; i++)
	{
		int x, y; cin >> x >> y;
		if (x == 1)
		{
			if (v[y].empty()||v[y].size()==1)
				cout << "no\n";
			else
				cout << "yes\n";
		}
		else
		{
			cout << "yes\n";
		}
	}

	return 0;
}
