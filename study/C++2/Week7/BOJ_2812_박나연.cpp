#include<iostream>
#include<string>
#include<deque>
using namespace std;

int main() {

	int N, K;
	//char S[500001];
	string S;

	cin >> N >> K;
	cin >> S;

	deque<char> d;

	/*
	int p = 1;

	for (int i = 1; i < N; i++) {
		cin >> S[p];
		while (p && K != 0 && S[p - 1] < S[p]) {
			K--;
			S[p - 1] = S[p];
			S[p] = 0;
		}
		
		
	}*/
	
	//deque
	for (int i = 0; i < N; i++) {
		while (K != 0 && d.empty() != 0 && d.back() < S[i]) {
			d.pop_back();
			K--;
		}
		d.push_back(S[i]);
	}

	while (K--)
		d.pop_back();

	for (int i = 0; i < d.size(); i++) {
		cout << d[i];
	}

}