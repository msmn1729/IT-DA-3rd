#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
//setting
int A, B, C;
vector<int> water;
queue<pair<pair<int, int>, int>> q;
bool check[202][202][202] = { false, };

void bfs() {
	
	q.push(make_pair(make_pair(0, 0), C));

	while (!q.empty()) {

		int a = q.front().first.first;
		int b = q.front().first.second;
		int c = q.front().second;
		q.pop();

		if (check[a][b][c])
			continue;
		check[a][b][c] = true;

		//a 물통에 물이 없다면 water에 현재 c 값을 넣기
		if (a == 0)
			water.push_back(c);

		//a->b
		if (a + b > B) //a b 물의 양이 B보다 크다면 B에 가득, A에는 B에 주고 남은 물  
			q.push(make_pair(make_pair((a + b) - B, B), c));
		else
			q.push(make_pair(make_pair(0, a + b), c));
		
		//a->c
		if (a + c > C)
			q.push(make_pair(make_pair((a + c) - C, b), C));
		else
			q.push(make_pair(make_pair(0, b), a + c));

		//b->a
		if (b + a > A)
			q.push(make_pair(make_pair(A, (a + b) - A), c));
		else
			q.push(make_pair(make_pair(a + b, 0), c));

		//b->c
		if (b + c > C)
			q.push(make_pair(make_pair(a, (b + c) - C), C));
		else
			q.push(make_pair(make_pair(a, b + c), 0));

		//c->a
		if (c + a > A)
			q.push(make_pair(make_pair(A, b), (a + c) - A));
		else
			q.push(make_pair(make_pair(0, b), a + c));

		//c->b
		if (c + b > B)
			q.push(make_pair(make_pair(a, B), (c + b) - B));
		else
			q.push(make_pair(make_pair(a, b + c), 0));


	}

}


int main() {
	
	cin >> A >> B >> C;
	bfs();
	sort(water.begin(), water.end());

	for (int i = 1; i < water.size(); i++)
	{
		cout << water[i] << endl;
	}

}

//백준에서 틀렸다고 뜸. 어떤 예외처리를 안해줬는지 모르겠음