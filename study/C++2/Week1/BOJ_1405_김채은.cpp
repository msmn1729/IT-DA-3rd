/*BOJ_1405_¹ÌÄ£ ·Îº¿*/
#include<iostream>

using namespace std;

#define MAX 30

int num;
double percent[4];
bool visited[MAX][MAX];

// EWSN definition
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void Input()
{
    cin >> num;
    for (int i = 0; i < 4; i++)
    {
        int a;
        cin >> a;
        percent[i] = a / 100.0;
    }
}

double DFS(int x, int y, int cnt)
{
    if (cnt == num) return 1.0;

    visited[x][y] = true;
    double result = 0.0;

    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (visited[nx][ny] == true)
        	continue;
        result = result + percent[i] * DFS(nx, ny, cnt + 1);
    }

    visited[x][y] = false;
    return result;
}

void Solution()
{
    double R = DFS(14, 14, 0);
    cout.precision(2);
    cout << fixed << R << endl;
}

int main(void)
{
    Input();
    Solution();

    return 0;
}

