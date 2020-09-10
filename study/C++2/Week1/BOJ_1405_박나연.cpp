/*
#include <iostream>
using namespace std;

//동서남북으로 이동하기 위해서 
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };
int N;
int EWNS[4]; //동서남북 퍼센트 받아오기
int path[30][30]; //경로(14번 이동하니까)
double result;
int checked = 1; //방문했는지 안했는지 확인

double DFS(int x, int y, int count) {

	if (N == count) return 1.0f;

	path[x][y] = checked; 

	for (int i = 0; i < 4; i++)
	{
		if (path[x + dx[i]][y + dy[i]] == checked)
			continue;
		result = result + EWNS[i] + DFS(x + dx[i], y + dy[i], count + 1);
	}
	checked = 0;
	path[x][y] = checked;
	return result;
}



int main()
{

	cin >> N;
	float m;
	for (int i = 0; i < 4; i++)
	{
		cin >> m;
		EWNS[i] = m / 100.0;
	}
	cout << DFS(14, 14, 0);

}

*/


//처음에는 동서남북 값을 배열에 넣지 않고 받음
//->이때 코드가 더러워짐->그래서 배열에 넣음