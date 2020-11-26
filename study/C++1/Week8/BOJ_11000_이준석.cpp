#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
pair <int, int>arr[200001];
int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> arr[i].first >> arr[i].second;
	priority_queue<int, vector<int>, greater<int> > pq;
	sort(arr, arr + N);
	pq.push(arr[0].second);
	for (int i = 1; i < N; i++)
	{
		if (pq.top() <= arr[i].first)
		{
			pq.pop();
			pq.push(arr[i].second);
		}
		else
			pq.push(arr[i].second);
	}
	cout << pq.size();
}