#include <iostream>
#include <vector>

using namespace std;

vector<int> graph[501];
bool visit[501] = {false, };

int bfs(int startV)
{
    int numF = 0;

    visit[startV] = true;
    numF += graph[startV].size();

    for (int i : graph[startV]) visit[i] = true;

    for (int i : graph[startV]) {
        for (int j : graph[i]) {
            if (visit[j] == false) {
                visit[j] = true;
                numF++;                    
            }
        }
    }
    return numF;
}

void input()
{
    int numV, numE;
    int tmp1, tmp2;

    cin >> numV;
    cin >> numE;
    for (int i = 0; i < numE; i++) {
        cin >> tmp1 >> tmp2;
        graph[tmp1].push_back(tmp2);
        graph[tmp2].push_back(tmp1);
    }
}

int main(void)
{
    input();
    cout << bfs(1) << endl;

    return 0;
}