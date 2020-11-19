#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int arr[300001];
int main() {
	int D, N, t, result = 0, k = 0;
	bool s = false;
	cin >> D >> N;
	for (int i = 1; i <= D; i++)
	{
		if (i == 1)
			cin >> arr[i];
		else
		{
			cin >> arr[i];
			if (arr[i] > arr[i - 1])
				arr[i] = arr[i - 1];
		}
	}
	for (int j = 1; j <= N; j++)
	{
		cin >> t;
		int left = 1, right = D;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if (arr[mid] >= t)
				left = mid + 1;
			else
				right = mid - 1;
		}
		if (right > 0)
		{
			result = right;
			D = right - 1;
		}
		else
			s = true;
	}
	if (s)
		cout << 0;
	else
		cout << result;
}
