#include <iostream>

using namespace std;

//방향이 2의 제곱수 -> 이진수로 구분
//
const int MAX = 50;

bool visited[MAX][MAX];

string DectoBi(int num){
	int result = 0;
	for (int i=1; num>0; i*=10){
		int binary = num % 2;
		result += binary*i;
		num /= 2;
	}
	return result;
}

int main(){

	return 0;
}


