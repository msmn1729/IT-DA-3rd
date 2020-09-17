#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;

#define MAX 200+1

//각 물통의 상태가 중요
//cycle되거나, a=0되면 return
int a, b, c;
bool visited[MAX][MAX][MAX]={false, };
vector<int> answer;

struct Status{
	int a;
	int b;
	int c;
};

void bfs(){
	queue<Status> Q;
	Q.push({0,0,c});

	while(!Q.empty()){
		Status u = Q.front();
		Q.pop();

		if(visited[u.a][u.b][u.c]==true)	continue;
		visited[u.a][u.b][u.c]=true;

		if(u.a==0)	answer.push_back(u.c); //원하는 사건


		//A->B
		if(u.a+u.b > b)	Q.push({u.a+u.b-b, b, u.c});
		else Q.push({0, u.a+u.b, u.c});

		//A->C
		if(u.a+u.c > c)	Q.push({u.a+u.c-c, u.b, c});
		else Q.push({0, u.b, u.a+u.c});

		//B->A
		if(u.b+u.a > a)	Q.push({a, u.b+u.a-a, u.c});
		else Q.push({u.b+u.a, 0, u.c});

		//B->C
		if(u.b+u.c > c)	Q.push({u.a, u.b+u.c-c, c});
		else Q.push({u.a, 0, u.b+u.c});

		//C->A
		if(u.c+u.a > a)	Q.push({a, u.b, u.c+u.a-a});
		else Q.push({u.a+u.c, u.b, 0});

		//C->B
		if(u.c+u.b > b)	Q.push({u.a, b, u.c+u.b-b});
		else Q.push({u.a, u.b+u.c, 0});
	}
}

void solution(){
	bfs();
	sort(answer.begin(), answer.end());
	for(int i=0; i < answer.size(); i++){
		cout << answer[i] << " ";
	}
}


int main(){
	cin >> a >> b >> c;
	solution();
	return 0;
}
