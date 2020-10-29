#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int arr[1000001] = { 0 };
vector<int> vec;
int main() {
	int N, result = 0;
	cin >> N;
	
	for (int i = 1; i <= N; i++)
	{
		cin >> arr[i];
	}
	vec.push_back(0);
	vec.push_back(arr[1]);
	for (int i = 2; i <= N; i++)
	{
		int n = vec.size();
		if (arr[i] < vec[n - 1] && arr[i]>vec[n - 2])
		{
			vec[n - 1] = arr[i];
		}
		else if (arr[i] > vec[n - 1])
			vec.push_back(arr[i]);
	}
	cout << (vec.size()-1);
}