#include<iostream>
#include<string>
using namespace std;

int main() {

	string lang;
	string result;
	cin >> lang;
	int i;
	bool c = false;
	bool java = false;
	bool error = false;

	for (i = 0; i < lang.length(); i++) {
		if ('A' <= lang[i] && 'Z' >= lang[i]) {//java
			if (c == true)
			{
				error = true;
				break;
			}
			
			result += '_' + lang[i] - 'A' + 'a';
			java = true;
		}
		else if (lang[i] == '_') {//c++
			if (java == true || i == lang.length()-1 || lang[i + 1] == '_' || (lang[i + 1] >= 'A' && lang[i + 1] <= 'Z'))
			{
				error = true;
				break;
			}
			result += lang[i + 1] - 'a' + 'A';
			i++;
			c = true;

		}
		else {
			result += lang[i];
		}
	}

	if (error == true)
		cout << "Error!" << endl;
	else
		cout << result << endl;

}

//예외처리,,,,