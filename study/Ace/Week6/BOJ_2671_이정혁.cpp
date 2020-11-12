#include<iostream>
#include<string>

using namespace std;
string s;
bool tf;
int type1(string s1, int idx) {
	if (idx + 4 > s.length() - 1) {
		tf = true;
		return 0;
	}
	if (s1[idx] == '0' || s1[idx + 1] == '1') {
		tf = true;
		return 0;
	}
	idx = idx + 2;
	if (s1[idx] == '1') {
		tf = true;
		return 0;
	}
	while (s1[idx++] == '0') {
		if (idx >= s.length() - 1) {
			tf = true;
			return 0;
		}
		if (s1[idx] == '1')
		{
			break;
		}
	}
	if (s1[idx] == '0') {
		tf = true;
		return 0;
	}
	while (s1[idx++] == '1') {
		if (idx >= s.length() - 1) {
			tf = true;
			return 0;
		}
		if (s1[idx] == '0')
		{
			return idx;
		}
	}
	return idx;
}
int type2(string s2, int idx) {
	if (idx + 2 > s.length() - 1) {
		tf = true;
		return 0;
	}
	if (s2[idx] == '0'&& s2[idx + 1] == '1') {
		idx += 2;
	}
	else {
		tf = true;
		return 0;
	}
	return idx;
}
int main(void) {
	cin >> s;
	if (s[0] == '0' && s[1] == '0') {
		cout << "NOISE";
		return 0;
	}
	if (s[0] == '1' && s[1] == '1') {
		cout << "SUBMARINE";
		return 0;
	}
	int check = 0;
	while (check != 149 ) {
		if (check >= s.length() - 1) {
			break;
		}
		if (s[check] == '1') {
			int check1 = check;
			check = type1(s, check1);
		}
		if (s[check] == '0') {
			int check1 = check;
			check = type2(s, check);
		}
	}
	if (tf == true) {
		cout << "NOISE";
		return 0;
	}
	else {
		cout << "SUBMARINE";
	}
	return 0;
}
