#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
	int T, N, L;
	cin >> T;
	vector<int>answer;
	while (T--) {
		cin >> N;
		vector<int>vec;
		int result = -1;
		for (int i = 0; i < N; i++)
		{
			cin >> L;
			vec.push_back(L);
		}
		sort(vec.begin(), vec.end());
		for (int i = 2; i < N; i++)
		{
			result = max(result, vec[i] - vec[i - 2]);
		}
		answer.push_back(result);
	}
	for (int i = 0; i < answer.size(); i++)
	{
		cout << answer[i] << endl;
	}
}