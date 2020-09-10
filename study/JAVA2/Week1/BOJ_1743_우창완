#include <bits/stdc++.h>
using namespace std;
int map_count[101][101];
bool check[101][101];
int dx[4]={1,0,-1,0};
int dy[4]={0,1,0,-1};
int answer=0;
//가로 세로 횟수
int n,m,k;
int bfs(int y, int x){
	queue<pair<int,int>> q;
	int count=1;
	check[y][x]=true;
	q.push(make_pair(y,x));
	while(!q.empty()){
		int x=q.front().second;
		int y=q.front().first;
		q.pop();
		for(int i=0; i<4; i++){
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(check[ny][nx]==false&&map_count[ny][nx]==1){
				if(nx>=1&& ny>=1&& nx<=m&&ny<=n){
					check[ny][nx]=true;
					q.push(make_pair(ny,nx));
					count++;	
				}
			}
		}
	}
	// cout<<count<<endl;
	return count;
}
int main() {
	int r,c;
	cin>>n>>m>>k;
	for(int i=0; i<k; i++){
		cin>>r>>c;
		map_count[c][r]=1;
	}
	for(int i=1; i<=n; i++){
		for(int j=1; j<=m; j++){
			if(map_count[i][j]==1&&check[i][j]==false){
				answer=max(answer,bfs(i,j));
			}
		}
	}
	cout<<answer;
	return 0;
}