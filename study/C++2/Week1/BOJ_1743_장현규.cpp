#include<iostream>
using namespace std;
int dix[4] = { 1,-1,0,0 };
int diy[4] = { 0,0,1,-1 };
int** location;
int N, M;
char** p;
int max = 0;
int main(void) {
	int  count;
	int i, j, k,x,y,c=0;
	bool t = true;
	cin >> N >> M>>count;
	p = new char* [N];
	location = new int* [N];
	for (i = 0; i < N; i++) {
		p[i] = new char[M];
		location[i] = new int[M];
		for (j = 0; j < M; j++) {
			p[i][j] = '.';
			location[i][j] = 0;
		}
	}
	for (i = 0; i < count; i++) {
		cin >> x>> y;
		p[x - 1][y - 1] = '#';
		
	}for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			cout << p[i][j];
		}
		cout << endl;
	}
	for (i = 0; i < N; i++) {
		t = false;
		for (j = 0; j < M; j++) {
			if (p[i][j] == '#') {
				c++;
				cout << c;
				if (i == N - 1) {
					t = true;
					continue;
				}
				if (p[i + 1][j] == '#') {
					t = true;
				}
			}
		}
		if (max < c) {
			c = max;
		}
		if (!t) {
			c = 0;
		}
	}
	cout << max;
	return 0;
}