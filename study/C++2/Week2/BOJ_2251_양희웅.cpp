#include <iostream>
#include <queue>

using namespace std;

typedef struct
{
    int A;
    int B;
    int C;
} Bucket;

int A, B, C;
bool check[201][201] = {false, };
bool answer[201] = {false, };

void bfs(Bucket start)
{
    queue<Bucket> q;
    q.push(start);

    while (!q.empty()) {
        Bucket next = q.front();
        q.pop();

        if (check[next.A][next.B]) {
            continue;
        }
        else {
            check[next.A][next.B] = true;
        }

        if (next.A == 0) {
            answer[next.C] = true;
        }

        // A -> B
        if (next.A + next.B > B) {
            q.push({next.A + next.B - B, B, next.C});
        }
        else {
            q.push({0, next.A + next.B, next.C});
        }
        // A -> C
        if (next.A + next.C > C) {
            q.push({next.A + next.C - C, next.B, C});
        }
        else {
            q.push({0, next.B, next.A + next.C});
        }

        // B -> A
        if (next.B + next.A > A) {
            q.push({A, next.B + next.A - A, next.C});
        }
        else {
            q.push({next.B + next.A, 0, next.C});
        }
        // B -> C
        if (next.B + next.C > C) {
            q.push({next.A, next.B + next.C - C, C});
        }
        else {
            q.push({next.A, 0, next.B + next.C});
        }

        // C -> A
        if (next.C + next.A > A) {
            q.push({A, next.B, next.C + next.A - A});
        }
        else {
            q.push({next.C + next.A, next.B, 0});
        }
        // C -> B
        if (next.C + next.B > B) {
            q.push({next.A, B, next.C + next.B - B});
        }
        else {
            q.push({next.A, next.C + next.B, 0});
        }
    }
}

void solve()
{
    bfs({0, 0, C});
    for (int i = 0; i <= C; i++) {
        if (answer[i]) {
            cout << i << " ";
        }
    }
}

void input()
{
    cin >> A >> B >> C;
}

int main(void)
{
    input();
    solve();

    return 0;
}