#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>


using namespace std;
int N;
int newV;
vector <int> anw;
int sosu[5] = { 1,3,5,7,9 };

bool calculate(int num) {
	for (int i = 2; i < num/2; i++) {
		if (num % i == 0) { return false; }
	}
	return true;
}

void dfs(int V, int cnt) {
	if (cnt == N) {
		anw.push_back(V);
		return;
	}
	for (int i = 0; i < 5; i++) {
		newV = V * 10 + sosu[i];
		if (calculate(newV) != 0) {
			dfs(newV, cnt + 1);
		}
	}
}
int main()
{
	cin >> N;
	dfs(2, 1);
	dfs(3, 1);
	dfs(5, 1);
	dfs(7, 1);

	sort(anw.begin(), anw.end());
	for (int i = 0; i < anw.size();i++) {
		cout << anw[i] << "\n";
	}
}