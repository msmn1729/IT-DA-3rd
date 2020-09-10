#include<iostream>
using namespace std;


int main() {

	int n, m;
	cin >> n >> m;

	int fri[501][501] = { 0. };
	int checked[501] = { 0, };

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		fri[a][b] = 1;
		fri[b][a] = 1;//친구
	}
		

	for (int i = 0; i < n; i++)
	{
		if (fri[0][i] == 1)//상근이 친구일 때
		{
			checked[i] = 1; //체크해줌
			for (int j = 0; j < n; i++) {
				if (fri[i][j] == 1)//상근이 친구의 친구일 때
				{
					checked[j] = 1;
				}
			}

		}
	}

	int count = 0;

	for (int i = 0; i < n; i++)
	{
		if (checked[i] == 1)
		{
			count = count + 1;
		}
	}


	cout << count;

}

//답이 안나옴,,, 로직은 많는 것 같은데