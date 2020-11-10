#include<iostream>
#include<string>
using namespace std;
long long num;

bool isprime(long long n) { // 소수 판별하기
	for (long long i = 2; i*i <= n; i++) { // n의 제곱근 까지만 계산하면 되므로
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}

bool drome(string n) {
	for (long long i = 0; i <= n.length()/2; i++) {
		if (n[i] != n[n.length() - 1 - i]) {
			return false;
		}
	}
	return true;
}

int main(void) {
	cin >> num;
	if (num == 1) {
		cout << 2;
		return 0;
	}
	while (1) {
		
		string s = to_string(num);
		if (isprime(num) == true && drome(s) == true) {
			cout << num;
			return 0;
		}
		if (num % 2 == 0)
			num++;
		else {
			num += 2;
		}
	}
	return 0;
}