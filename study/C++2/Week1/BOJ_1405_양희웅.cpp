#include <iostream>

using namespace std;

bool space[29][29] = {false,};
double probability[4];

int directionX[4] = {1, -1, 0, 0};
int directionY[4] = {0, 0, -1, 1};

double dfs(int x, int y, int moveCount)
{
    int nextX;
    int nextY;
    
    if (moveCount == 0) {
        return 1.0;
    }

    space[x][y] = true;
    double result = 0.0;

    for (int i = 0; i < 4; i++){
        nextX = x + directionX[i];
        nextY = y + directionY[i];

        if (space[nextX][nextY] == true) {
            continue;
        }
        result += probability[i] * dfs(nextX, nextY, moveCount - 1);
    }
    space[x][y] = false;

    return result;
}

int main(void)
{
    ios::sync_with_stdio(false);
    int moveCount;
    cin >> moveCount >> probability[0] >> probability[1] >> probability[2] >> probability[3];

    for (int i = 0; i < 4; i++) {
        probability[i] /= 100.0;
    }

    double result = dfs(14, 14, moveCount);

    cout << fixed;
    cout.precision(10);
    cout << result << endl;

    return 0;
}
