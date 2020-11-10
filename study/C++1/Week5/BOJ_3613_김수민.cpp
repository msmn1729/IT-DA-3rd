#include <iostream>
#include <string>
#include <cstring>
#include <vector>

using namespace std;
string v;
vector <char> newword;
int cused, javaused;
int main()
{
	cin >> v;
	newword.push_back(v[0]);
	
	for (int i = 1; i < v.size(); i++) {
		if ((v[i] >= 97) && (v[i] <= 122) && (v[i - 1] != 95)) { //안바꿔도 되는 소문자일 때
			newword.push_back(v[i]);
		}
		else if ((v[i] >= 97) && (v[i] <= 122) && (v[i - 1] == 95)) { //_뒤에 나와서 대문자로 바꿔야 되는 소문자(c++일때)
			newword.push_back(v[i] - 32);
			cused++;
		}
		else if (v[i] == 95) { //_ 쓰였을 때 (c++일때)
			if (v[i + 1] == 95) {
				cout << "Error!";
				return 0;
			}
			cused++;
		}
		else if ((v[i] >= 65) && (v[i] <= 90)) {//대문자 쓰였을 때(java일때)
			newword.push_back('_');
			newword.push_back(v[i] + 32);
			javaused++;
		}
		
		else { //이 중에 없으면 c++이나 java 형식이 아니므로
			cout<<"Error!";
			return 0;
		}
	}
	
	if (((v[0] < 97) or (v[0] > 122))or((javaused!=0)&&(cused!=0))or(v[v.size()-1]==95)) { //시작이 소문자가 아니거나, 대문자와 _가 같이 쓰였거나, 끝이 _로 끝날 때
			cout << "Error!";
			return 0;
		}
	for (int i = 0; i < newword.size();i++) {
		cout << newword[i];
	}
}
