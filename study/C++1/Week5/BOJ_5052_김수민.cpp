#include <iostream>
#include <string>
#include <cstring>
#include <cstdio>

using namespace std;

//Trie (블로그 참고..)

int char_to_index(char c) {
	return c - '0';
}

struct Trie {

	bool is_terminal;

	Trie* next[10];
	Trie() : is_terminal(false) {
		memset(next, 0, sizeof(next));
	}

	~Trie() {
		for (int i = 0; i < 10; ++i) {
			if (next[i]) {
				delete next[i];
			}
		}
	}

	void insert(const char* key) {

		if (*key == '\0') { //널문자 만나면 is_terminal을 true로 바꿔준다
			is_terminal = true;
		}
		else {
			int index = char_to_index(*key);
			if (next[index] == 0)
				next[index] = new Trie();
			next[index]->insert(key + 1);
		}
	}
	//접두사에 중복된 전화번호가 있는지 확인하는
	bool find(const char* key) {

		if (*key == '\0') return true; //중복되는 접두사 존재 x

		if (is_terminal) return false; //아까 삽입할때 널문자 있으면 is_terminal이 true 값이었는데 탐색 할때 발견되거면 중복되는 접두사 O

		int index = char_to_index(*key);
		return next[index]->find(key + 1);
	}
};

int main() {

	int t;
	char a[10000][11]; //전화번호부
	cin >> t;

	for (int i=0; i<t; i++){
	
		int n;
		cin >> n;

		Trie* root = new Trie();
		for (int i = 0; i < n; ++i) {
			cin>>a[i];
			root->insert(a[i]);
		}

		bool is_valid = true;
		for (int i = 0; i < n; ++i) {

			if (root->find(a[i]) == false) { //일관성 x
				is_valid = false;
				break;
			}
		}
		delete root;
		if (is_valid) { cout << "YES"<<"\n"; }
		else { cout << "NO"<<"\n"; }
	}
	return 0;
}
