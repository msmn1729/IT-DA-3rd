#include <iostream>
#include <vector>

using namespace std;

typedef struct dot
{
    int x;
    int y;
} dot;

int t;
int n;
vector<int> graph[102];
bool check[102] = {false, };

int distance(dot a, dot b)
{
    return abs(a.x - b.x) + abs(a.y - b.y);
}

void DFS(int start)
{
    check[start] = true;

    for (int i = 0; i < graph[start].size(); i++) {
        int next = graph[start][i];
        if (check[next] == false) {
            DFS(next);
        }
    }
}

int main(void)
{
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> n;
        vector<dot> location;

        for (int j = 0; j < n + 2; j++) {
            dot tmp;
            cin >> tmp.x >> tmp.y;
            location.push_back(tmp);
        }

        for (int j = 0; j < n + 2; j++) {
            for (int k = j + 1; k < n + 2; k++) {
                if (distance(location[j], location[k]) <= 1000) {
                    graph[j].push_back(k);
                    graph[k].push_back(j);
                }
            }
        }
        DFS(0);

        if (check[n + 1]) {
            cout << "happy" << endl;
        }
        else {
            cout << "sad" << endl;
        }
    }

    return 0;
}