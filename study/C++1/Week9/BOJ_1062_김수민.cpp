#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;
int N, K;
bool alphabet[26];
vector <string> v;
int result=0;

void check() {
	int tempresult = 0;
	for (int i = 0; i < N; i++) {
		bool flag = false;
		for (int j = 0; j < v[i].length();j++) {
			if (!alphabet[v[i][j] - 97]) { //알파벳 안배웠으면
				flag = true;
				break;
			}
		}
		if (!flag) {//한 글자도 안배운 글자 없으면
			tempresult++;
		}
	}
	result = max(result, tempresult);
	return;

}
void learn(int a, int b) {
	if (b == K) {
		check();
		return;
	}
	else {
		for (int i = a; i < 26; i++) { //알파벳 하나씩 돌면서 확인하는
			if (!alphabet[i]) {
				alphabet[i] = true;
				learn(i, b + 1);
				alphabet[i] = false;
			}
		}
	}
	
}

int main()
{
	
	cin >> N >> K;
	
	
	if (K < 5) {
		cout << 0 << "\n";
		return 0;
	}
	else if (K == 26) {
		cout << N << "\n";
		return 0;
	}
	alphabet['a' - 97] = true;
	alphabet['c' - 97] = true;
	alphabet['i' - 97] = true;
	alphabet['n' - 97] = true;
	alphabet['t' - 97] = true;
	K -= 5;

	for (int i = 0; i < N; i++) {
		string word;
		cin >> word;
		word.erase(word.begin(), word.begin() + 4);
		word.erase(word.end() - 4, word.end());
		v.push_back(word);
	}
	learn(0, 0);
    cout << result<<"\n";
}
