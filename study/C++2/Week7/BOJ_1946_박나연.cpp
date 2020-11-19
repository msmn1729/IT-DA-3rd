#include<iostream>

using namespace std;

int main() {

	int T, N;
	int count = 0;
	int test[100001][2] = { 0, };


	cin >> T;

	for (int i = 0; i < T; i++) {

		cin >> N;
		for (int j = 0; j < N; j++) {
			cin >> test[j][0];
			cin >> test[j][1];
		}


		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (test[j][0] > test[k][0])
					if (test[j][1] > test[k][1]) {
						count++;
						break;
					}
			}
		}
		cout << N-count << endl;
		count = 0;
	}

}


