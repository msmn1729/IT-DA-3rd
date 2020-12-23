#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
//도저히 모르겠어서 블로그에서 가져옴

typedef long long ll;
int a[1000001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m;
	cin >> n >> m;
	ll lo = 1LL;
	ll hi = 1000000000001LL;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	while (lo + 1 < hi)
	{
		ll mid = (lo + hi) / 2;
		ll cnt = 0;
		for (int i = 0; i < n; i++)
			cnt += mid / a[i];
		if (cnt >= m) hi = mid;
		else          lo = mid;
	}
	cout << hi;
	return 0;

}

