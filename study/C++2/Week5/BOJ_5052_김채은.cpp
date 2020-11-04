#include<iostream>
#include<string>
#include<algorithm>

using namespace std;
int testCase;
int s[51]={-1,};
string arr[51][10001]={"n",}; //[testcase횟수][번호 개수]
int ans[51]={0,};

void Input(){
	int S;
	cin>>testCase;
	for(int i=0; i<testCase; i++){
		cin>>S;
		s[i]=S;
		for(int j=0; j<s[i]; j++)
			cin>>arr[i][j];
	}
}

void Solution(){
	for(int i=0; i<testCase; i++){
		sort(arr[i],arr[i]+s[i]);
		for(int j=0; j<s[i]-1; j++){
//			if(string::npos!=arr[i][j+1].find(arr[i][j])){
//				ans[i]=-1;
//				break;
//			}
			if (arr[i][j]==arr[i][j+1].substr(0,arr[i][j].size())) {
				ans[i] = -1;
				break;
			}
		}
	}
	for(int i=0; i<testCase; i++){
		if(ans[i]==-1)
			cout<<"NO"<<endl;
		else
			cout<<"YES"<<endl;
	}
}

int main(){
	Input();
	Solution();
	return 0;
}

