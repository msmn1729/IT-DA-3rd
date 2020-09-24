/*
 * DP(memoization), DFS
 * Whole/Half의 개수를 저장하면서 푼다, 트리만들기
 * 알약 3개 = 알약 2개의 경우에서 추가
 *
 */
#include<iostream>
using namespace std;
#define MAX 30+1

int n;
long long pill[MAX][MAX]={0, };

long long dfs(int w, int h){
	if(pill[w][h]) //시간 단축
		return pill[w][h];
	if(w==0)
		return 1;

	pill[w][h] = dfs(w-1, h+1);
	if(h>0)
		pill[w][h] += dfs(w, h-1);

	return pill[w][h];
}

void solution(){
	while(1){
		cin >> n;
		if(n==0)	break;
		cout << dfs(n,0) << endl;
	}
}

int main(){
	solution();
	return 0;
}




