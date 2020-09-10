#include <iostream>
#include <queue>

using namespace std;

typedef struct
{
    int x, y;
    int moveCnt;
    int horseMove;
} dot;

int space[200][200];
bool check[200][200] = {false, };
queue<dot> q;

int horseCnt;
dot startPos = {0, 0, 0, 0};
dot endPos;

int monkeyX[] = {-1, 0, 1, 0};
int monkeyY[] = {0, -1, 0, 1};
int horseX[] = {-2, -1,  1,  2, 2, 1, -1, -2};
int horseY[] = {-1, -2, -2, -1, 1, 2,  2,  1};

int bfs()
{
    q.push(startPos);
    check[startPos.x][startPos.y] = true;

    while(!q.empty()) {
        dot curPos = q.front();
        dot nextPos = curPos;
        q.pop();

        for (int i = 0; i < 12; i++) {
            if (i < 4) { //원숭이 move
                cout << endl << "원숭이 move ------------------------------" << endl;
                cout << "i: " << i << endl;
                cout << "curPos.x: " << curPos.x << ", curPos.y: " << curPos.y << endl;
                cout << "x축 " << monkeyX[i] << "이동, y축 " << monkeyY[i] << "이동" << endl;

                nextPos.x = curPos.x + monkeyX[i];
                nextPos.y = curPos.y + monkeyY[i];
                cout << "nextPos.x: " << nextPos.x << ", nextPos.y: " << nextPos.y << endl;
                cout << "space[" << nextPos.x << "][" << nextPos.y << "]: " << space[nextPos.x][nextPos.y] << endl;               

                if ((nextPos.x >= 0 && nextPos.x < endPos.x) && (nextPos.y >= 0 && nextPos.y < endPos.y)) { //말판 범위 이내라면
                    if ((space[nextPos.x][nextPos.y] != 1) && (check[nextPos.x][nextPos.y] == false)) { //장애물이 아니거나 아무도 방문하지 않은 곳이면
                        nextPos.moveCnt = curPos.moveCnt + 1;
                        if (curPos.moveCnt != 0 && nextPos.moveCnt != 0 && nextPos.moveCnt <= curPos.moveCnt) {
                            cout << "fail: 이동횟수" << endl;
                            cout << "curPos.moveCnt: " << curPos.moveCnt << endl;
                            cout << "nextPos.moveCnt: " << nextPos.moveCnt << endl;
                            continue;
                        }
                        if (nextPos.x == endPos.x - 1 && nextPos.y == endPos.y -1) { // 목적지 도착이라면
                            cout << "도착!" << endl;
                            return nextPos.moveCnt;
                        }
                        q.push(nextPos);
                        check[nextPos.x][nextPos.y] = true;
                        cout << endl << "success: 탐색 완료" << endl;
                        cout << "moveCnt of nextPos: " << nextPos.moveCnt << endl;
                    }
                    else {
                        cout << endl << "fail: 장애물 or 한번 방문" << endl;
                        cout << "check[" << nextPos.x << "][" << nextPos.y << "]: " << check[nextPos.y][nextPos.x] << endl;
                        cout << "space[" << nextPos.x << "][" << nextPos.y << "]: " << space[nextPos.y][nextPos.x] << endl;
                        continue;
                    }
                }
                else {
                    cout << endl << "fail: 말판 범위 벗어남" << endl;
                    continue;
                }
            }
            else if (i >= 4 && i < 12) { //말 move
                cout << endl << "말 move ------------------------------" << endl;
                cout << "i: " << i << endl;
                cout << "curPos.x: " << curPos.x << ", curPos.y: " << curPos.y << endl;
                cout << "x축 " << horseX[i - 4] << "이동, y축 " << horseY[i - 4] << "이동" << endl;

                nextPos.x = curPos.x + horseX[i - 4];
                nextPos.y = curPos.y + horseY[i - 4];
                cout << "nextPos.x: " << nextPos.x << ", nextPos.y: " << nextPos.y << endl;
                cout << "space[" << nextPos.x << "][" << nextPos.y << "]: " << space[nextPos.x][nextPos.y] << endl;

                if ((nextPos.x >= 0 && nextPos.x < endPos.x) && (nextPos.y >= 0 && nextPos.y < endPos.y)) { //말판 범위 이내라면
                    if ((check[nextPos.x][nextPos.y] == false) && (space[nextPos.x][nextPos.y] != 1)) { //장애물이 아니거나 아무도 방문하지 않은 곳이면
                        nextPos.moveCnt = curPos.moveCnt + 1;
                        if (curPos.moveCnt != 0 && nextPos.moveCnt != 0 && nextPos.moveCnt <= curPos.moveCnt) {
                            cout << "fail: 이동횟수" << endl;
                            cout << "curPos.moveCnt: " << curPos.moveCnt << endl;
                            cout << "nextPos.moveCnt: " << nextPos.moveCnt << endl;
                            continue;
                        }
                        if (nextPos.horseMove > horseCnt) {
                            continue;
                        }
                        nextPos.horseMove++;
                        if (nextPos.x == endPos.x - 1 && nextPos.y == endPos.y - 1) { // 목적지 도착이라면
                            cout << "도착!" << endl;
                            return nextPos.moveCnt;
                        }
                        q.push(nextPos);
                        check[nextPos.x][nextPos.y] = true;
                        cout << endl << "success: 탐색 완료" << endl;
                        cout << "moveCnt of nextPos: " << nextPos.moveCnt << endl;
                        cout << "horseMove of nextPos: " << nextPos.horseMove << endl;
                    }
                    else {
                        cout << endl << "fail: 장애물 or 한번 방문" << endl;
                        cout << "check[" << nextPos.x << "][" << nextPos.y << "]: " << check[nextPos.x][nextPos.y] << endl;
                        cout << "space[" << nextPos.x << "][" << nextPos.y << "]: " << space[nextPos.x][nextPos.y] << endl;
                        continue;
                    }
                }
                else {
                    cout << endl << "fail: 말판 범위 벗어남 or 말 이동 횟수 초과" << endl;
                    cout << "horseMove of curPos: " << curPos.horseMove << endl;
                    continue;
                }
            }
        }
    }
    return -1;
}

int main(void)
{
    cin >> horseCnt;
    cin >> endPos.x >> endPos.y;

    endPos.moveCnt = 0;
    endPos.horseMove = 0;

    for (int j = 0; j < endPos.y; j++) {
        for (int i = 0; i < endPos.x; i++) {
            cin >> space[i][j];
        }
    }

    cout << bfs() << endl;

    return 0;
}