#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 500+1
int n, m; //세로 가로
char cells[MAX][MAX];
bool visited[MAX][MAX] = {false, };
vector<int> pics;


int dfs(int i, int j){
	visited[i][j]=true;
	int size = 0;
	size++;

	if(i-1>=0 && cells[i][j]=='1' && !visited[i][j])
		size += dfs(i-1, j);

	if(i+1<n && cells[i][j]=='1' && !visited[i][j])
		size += dfs(i+1, j);

	if(j-1>=0 && cells[i][j]=='1' && !visited[i][j])
		size += dfs(i, j-1);

	if(j+1<m && cells[i][j]=='1' && !visited[i][j])
		size += dfs(i, j+1);

	return size;
}

void solution(){
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			int picSize=0;
			if(cells[i][j]=='1' && !visited[i][j])
				picSize = dfs(i,j);
			if(picSize>=1)
				pics.push_back(picSize);
		}
	}

	cout << pics.size() << endl;

	cout << *max_element(pics.begin(), pics.end())<<endl;

}

void input(){
	cin >> n >> m;
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++)
			cin >> cells[i][j];
	}
}
int main() {
	input();
	solution();
	return 0;
}

