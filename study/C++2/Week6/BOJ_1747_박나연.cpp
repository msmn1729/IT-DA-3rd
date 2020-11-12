#include<iostream>
#include<string>
using namespace std;

int main() {

	int p[2000000];
	int N;
	bool isChecked = false;
	int result = 0;

	cin >> N;

	p[1] = 1;
	for (int i = 2; i * i <= 2000000; i++) {
		if (2000000 % i == 0) {
			p[i] = 1;
		}
		p[i] = 0;
	}

	for (int i = N; i <= 2000000; i++) {
		if (p[i] == 0) {
			string s = to_string(i);
			int j = 0;
			int k = s.length() - 1;
			while (j <= k) {
				if (s[j] == s[k]) {
					j++;
					k--;
				}
				else {
					isChecked = false;
					break;
				}
			}
			if (isChecked == true) {
				result = i;
				break;
			}
		}
	}

	cout << result;


}