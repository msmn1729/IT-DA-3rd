#include<iostream>

using namespace std;

int N, S, M;
int arr[101]={-1};
int dp[101][1001]={-1,};

int DP(int indx, int vol){
	if(vol<0 || vol>M)
		return -10;

	if(indx==N)		//end
		return dp[indx][vol]=vol;

	if(dp[indx][vol]!=-1)
		return dp[indx][vol];

	int max=DP(indx+1,vol+arr[indx]);
	if(int temp=DP(indx+1,vol-arr[indx])>max)
		max=temp;
	dp[indx][vol]=max;
	return dp[indx][vol];
}

void Input(){
	cin>>N>>S>>M;
	for(int i=0; i<N; i++)
		cin>>arr[i];
}

void Solution(){
	int result=DP(0,S);
	if(result==-10)
		cout<<-1;
	else	cout<<result;
}

int main()
{
	Input();
	Solution();
	return 0;
}
