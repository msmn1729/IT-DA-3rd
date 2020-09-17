#include <iostream>
#include <stdio.h>
using namespace std;
int col[30][30] = { 0 };
int dx[4] = { 0,0,1,-1 }; // E,W,S,N
int dy[4] = { 1,-1,0,0 };
double arr[4];
double result = 0.0;
double dfs(int x, int y, int cnt)
{
    if (cnt == 0)
        return 1.0;
    double result = 0.0;
    col[x][y] = 1;
    for (int i = 0; i < 4; i++) {
        int cx = x + dx[i];
        int cy = y + dy[i];
        if (col[cx][cy] != 0)
            continue;
        else
            result += dfs(cx, cy, cnt - 1) * arr[i];
    }
    col[x][y] = 0;
    return result;
}
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < 4; i++) {
		scanf("%lf", &arr[i]);
		arr[i] /= 100.0;
	}
	printf("%.9lf", dfs(15, 15, n));

}
