#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

int N;
bool checked[100000] = { false };
bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.second == b.second) {
		return a.first < b.second;
	}
	return a.second < b.second;

}

int main()
{
	int lecturenum = 0;
	int anw=0;
	deque <pair<int, int>> v;
	int start, end;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		v.push_back(make_pair(start, end));

	}
	sort(v.begin(), v.end(),compare);
	
	while (lecturenum!=N) {
		anw += 1;
		int end_time=0;
		for (int i = 0; i < N; i++) {

			if ((v[i].first >= end_time)&&(checked[i]==false)) {
				checked[i] = true;
				end_time = v[i].second;
				lecturenum++;
			}
		}
	}
	
	cout << anw;
}