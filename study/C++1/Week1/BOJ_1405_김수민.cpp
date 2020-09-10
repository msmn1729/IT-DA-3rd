//1405 미친 로봇
#include <iostream>
#include <cstdio>
using namespace std;

bool visited[30][30];
int move_a[4] = { 1,-1,0,0 };
int move_b[4] = { 0,0,-1,1 };
double eachper[4]; //각각의 확률
int N;
int a2, b2;//이동 후의 위치
double per = 0; //총 확률
double temp = 1; //각 움직임마다 곱해서 총 확률에 넣어 줄 임시적 변수

void dfs(int cnt, int a, int b, double p) {
	if (cnt == N) { //입력 횟수만큼 움직였으면 마지막 움직임을 곱해주고, 리턴한다
		if (visited[a][b] != true) {//마지막에도 갔던 곳을 가면 안되니까 
			temp *= p;
			per += temp;
			temp /= p; //바로 전 상태로 돌아가니까 확률을 다시 나눠준다
		}
		return;
	}

	if (visited[a][b] != true) {
		for (int i = 0; i < 4; i++) {
			if (eachper[i] != 0) { //확률이 0이면 나눌 때 오류나니까 확률 0일때는 스킵
				temp *= p; 
				visited[a][b] = true; 
				a2 = a + move_a[i], b2 = b + move_b[i]; //이동 후 위치를 move배열을 통해 설정하고
				dfs(cnt + 1, a2, b2, eachper[i]); //cnt를 증가시키며 깊이 탐색한다
				visited[a][b] = false; //dfs를 빠져나오면 새로운 경로를 구해야 되니까 다시 방문 값을 false로 바꾸고
				temp /= p; //확률도 다시 나눠준다
			}
		}
	}
}

int main()
{
	cin >> N;
	for (int i = 0; i < 4; i++) {
		cin >> eachper[i];
		eachper[i] /= 100.0;
	}
	dfs(0, 15, 15, 1); //가운데 점 15,15를 기준으로 시작한다.
	printf("%.11f", per);
}