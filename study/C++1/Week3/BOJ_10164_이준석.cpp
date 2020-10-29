#include <iostream>
#include <string.h>
using namespace std;
int arr[16][16] = { 0 };
int dx[2] = { 1,0 };
int dy[2] = { 0,1 };
int main() {
	int N, M, K;
	cin >> N >> M >> K;
	int x, y, result = 1;
	if (K == 0)
	{
		arr[0][0] = 1;
		for (int i = 0; i <= N - 1; i++)
		{
			for (int j = 0; j <= M - 1; j++)
			{
				for (int k = 0; k < 2; k++)
				{
					arr[i + dx[k]][j + dy[k]] += arr[i][j];
				}
			}
		}
		cout << arr[N - 1][M - 1];
	}
	else {
		if (K % M == 0)
		{
			y = M - 1;
			x = K / M - 1;
		}
		else {
			y = K % M - 1;
			x = K / M;
		}
		arr[0][0] = 1;
		for (int i = 0; i <= x; i++)
		{
			for (int j = 0; j <= y; j++)
			{
				for (int k = 0; k < 2; k++)
				{
					arr[i + dx[k]][j + dy[k]] += arr[i][j];
				}
			}
		}
		result *= arr[x][y];
		memset(arr, 0, sizeof(arr));
		arr[x][y] = 1;
		for (int i = x; i <= N - 1; i++)
		{
			for (int j = y; j <= M - 1; j++)
			{
				for (int k = 0; k < 2; k++)
				{
					arr[i + dx[k]][j + dy[k]] += arr[i][j];
				}
			}
		}
		result *= arr[N - 1][M - 1];
		cout << result;
	}
}