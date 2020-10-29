#include<iostream>
using namespace std;

int main() {

	int num;
	cin >> num;

	if (num % 2 == 0) { //어차피 1과 3개만 뽑을 수 있으니까 돌이 짝수개면 마지막꺼는 항상 창영이가 들고간다.
		cout << "CY" << endl;
	}
	else {
		cout << "SK" << endl;
	}

}