#include<iostream>
using namespace std;


int main() {

	int D, N;
	int array_oven[300000];
	int array_finish[300000];
	
	cin >> D >> N;
	for (int i = 0; i < D; i++) {
		cin >> array_oven[i];
		if (array_oven[i - 1] < array_oven[i]) //더 작은 위치로 내려갈 수 없기 때문에
			array_oven[i] = array_oven[i - 1];
	}
	for (int i = 0; i < N; i++) {
		cin >> array_finish[i];
	}



}