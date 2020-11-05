//엥..모든 도시 다 가려면 n-1 아닌가..
#include<iostream>

using namespace std;

int main(){
	int testCase;
	cin>>testCase;
	int N,M;

	for(int i=0; i<testCase; i++){
		cin>>N>>M;
		for(int j=0; j<M; j++){
			int n1,n2;
			cin>>n1>>n2;
		}
		cout<<N-1<<endl;
	}
	return 0;
}


