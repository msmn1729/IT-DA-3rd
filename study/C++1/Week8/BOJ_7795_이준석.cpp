#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int arrN[20001];
int arrM[20001];
vector<int>vec;
int main() {
	int T, N, M;
	cin >> T;
	while (T--)
	{
		int cnt = 0;
		cin >> N >> M;
		for (int i = 0; i < N; i++)
			cin >> arrN[i];
		for (int i = 0; i < M; i++)
			cin >> arrM[i];
		sort(arrN, arrN + N);
		sort(arrM, arrM + M);
		for (int i = 0; i < N; i++)
		{
			int left = 0, right = M - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (arrM[mid] >= arrN[i])
				{
					right = mid - 1;
				}
				else
					left = mid + 1;
			}
			cnt=cnt+right + 1;
		}
		vec.push_back(cnt);
	}
	for (int i = 0; i < vec.size(); i++)
		cout << vec[i]<<endl;
}