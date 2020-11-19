#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
long long arr[1000000] = { 0 };
int main() {
	long long N, M, cnt = 0, k, mini=10000000;
	cin >> N >> M;
	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
		mini = min(mini, arr[i]);
	}
	long long left = 0, right = mini * M;
	while(left<=right)
	{ 
		long long mid = (left + right) / 2;
		long long result=0;
		for (int i = 0; i < N; i++)
			result = result + mid / arr[i];
		if (result < M)
			left = mid + 1;
		else
			right = mid - 1;
	}
	cout << left;
}