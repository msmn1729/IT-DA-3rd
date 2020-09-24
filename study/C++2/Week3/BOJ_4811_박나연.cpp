#include<iostream>
using namespace std;

long long dpArray[31][31];

long long dp(int w, int h) {

	if (w < 0 || h > 0)
		return 0;
	if (w == 0)
		return 1;

}

int main() {
	
	int drug;
	while (true) {
		cin >> drug;
		if (drug == 0)
			break;
		cout << dpArray[drug][0] << endl;
	}


}