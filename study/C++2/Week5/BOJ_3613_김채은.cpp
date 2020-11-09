#include <iostream>
#include <string>

using namespace std;

int main(){
	string str;
	cin>>str;
	int size=str.length();
	bool cpp=false;
	bool java=false;
	string ans="";

	for(int i=0; i<size; i++){
		if(str[i]=='_'){
			cpp=true;
			if(!(cpp*java))
				ans.push_back((char)toupper(str[++i]));
			else{
				cout<<"Error!";
				break;
			}
		}
		else if(isupper(str[i])){
			java=true;
			if(!(cpp*java)){
				ans.push_back('_');
				ans.push_back((char)tolower(str[i]));
			}
			else {
				cout << "Error!";
				break;
			}
		}
		else if(islower(str[i]))
			ans.push_back(str[i]);
		else {	//다른문자
			cout << "Error!";
			break;
		}
	}
	if(!(cpp*java))
		cout<<ans;
	return 0;
}
