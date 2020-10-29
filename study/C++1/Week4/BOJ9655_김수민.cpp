#include <stdio.h>
#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;
int N,S,M,F;
deque <int> a;
int V[1000];

int cal() {
	
	for (int i = 0; i < N; i++) {
		if (a.empty() == true) { return -1; }
		int cnt = a.size();
		while (cnt > 0) {
			F = a.front();
			if ((F + V[i] >= 0) && (F + V[i] <= M)) {
				a.push_back(F + V[i]);
			}
			if ((F - V[i] >= 0) && (F - V[i] <= M)) {
				a.push_back(F - V[i]);
			}
			a.pop_front();
			cnt--;
		}

	}
	sort(a.begin(), a.end(), greater<int>());
	return a.front();



}

int main(){
	cin >> N >> S >> M;
	for (int i = 0; i < N; i++) {
		cin >> V[i];
	}
	
	a.push_back(S);
	int result = cal();
	cout << result;
	
	
}