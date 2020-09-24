#include <iostream>

using namespace std;

int n, m, k;
int matrix[16][16] = {0, };

int dp(int n,int m){
	if(n==1 || m==1)
		return matrix[n][m] = 1;

	return matrix[n][m] = dp(n-1,m) + dp(n,m-1);

}

void solution(){
	int o,p;
	int num = 1;
	for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(num == k)
					o=i, p=j;
				num++;
			}
		}
	if(k==0)
		cout << dp(n-1,m) + dp(n,m-1);
	else
		cout << dp(o,p) + dp(n-o+1, m-p+1);
}

int main(){
	cin >> n >> m >> k;
	solution();
	return 0;
}


