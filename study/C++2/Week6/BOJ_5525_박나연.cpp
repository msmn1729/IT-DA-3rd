#include<iostream>
#include<string>
using namespace std;

int main() {

	int N, M;
	string String;
	int result = 0;
	int count = 0;

	cin >> N >> M >> String;

	for (int i = 0; i < M - 2; i++) {
		if (String[i] == 'I' && String[i + 1] == 'O' && String[i + 2] == 'I') {
			count++;
			if (count == N)
			{
				result = result + 1;
				count--;
			}
			i++; //error!
		}
		else
			count = 0;
	}

	cout << result << endl;



}