/*
 * DP
 * 이항계수의 성질 이용
 * nCk = n-1Ck-1 + n-1Ck (0<k<n)
 *       1 (k=0, k=n)
 *
 */
#include<iostream>

using namespace std;

#define MAX 100+1
int n, m;
long long C[MAX][MAX];

int min(int a, int b){
	if(a>=b)	return b;
	else	return a;
}

long long dp(int n, int m){
	int i,j;
	for(i=0; i<=n; i++){
		for(j=0; j<=min(i,m); j++){
			if(j==0 || j==i)
				C[i][j] = 1;
			else
				C[i][j] = C[i-1][j-1]+C[i-1][j];
		}
	}
	return C[n][m];
}

void solution(){
	cout << dp(n,m) <<endl;
}

int main(){
	cin >> n >> m;
	solution();
	return 0;
}


