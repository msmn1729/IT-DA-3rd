#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, num = 0;
int child[1000010];
int answer = 0;
vector<int> v;


int main() {

	cin >> N;


	for (int i = 1; i <= N; i++) {
		cin >> num;
		child[num] = child[num-1] + 1;
		if (child[num] > answer) {
			answer = child[num];
		}
	}

	cout << N - answer;

	
}

//LIS -- 아직 어려움