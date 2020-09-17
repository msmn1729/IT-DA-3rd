#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

int w, h, answer;
char map[101][101];
bool visited[101][101];
bool key[26];

int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };

vector<pair<int, int>> ent;

void bfs(int i,int j)
{
	queue<pair<pair<int, int>, int>> q;
	q.push({ {i,j},0 });	answer = 0;
	visited[i][j] = true;
	while (!q.empty)
	{
		int x = q.front().first.first; int y = q.front().first.second;
		int numOfK = q.front().second; q.pop();

		answer = max(answer, numOfK);

		for (int k = 0; k < 4; k++)
		{
			int nx = x + dx[k]; int ny = y + dy[k];

			if (0 <= nx && nx < w && 0 <= ny && ny < h)
			{
				if (map[nx][ny] != '*'&&!visited[nx][ny])
				{
					if (map[nx][ny] == '.')
					{
						visited[nx][ny] = true;
						q.push({ {nx,ny},numOfK });
					}
					if(map[nx][ny] == '$')
					{
						visited[nx][ny] = true;
						q.push({ { nx,ny },numOfK + 1 });
					}
					if (map[i][j] == 'a' || map[i][j] == 'b' || map[i][j] == 'c' || map[i][j] == 'd'
						|| map[i][j] == 'e' || map[i][j] == 'f' || map[i][j] == 'g' || map[i][j] == 'h'
						|| map[i][j] == 'i' || map[i][j] == 'j' || map[i][j] == 'k' || map[i][j] == 'l'
						|| map[i][j] == 'm' || map[i][j] == 'n' || map[i][j] == 'o' || map[i][j] == 'p'
						|| map[i][j] == 'q' || map[i][j] == 'r' || map[i][j] == 's' || map[i][j] == 't'
						|| map[i][j] == 'u' || map[i][j] == 'v' || map[i][j] == 'w' || map[i][j] == 'x'
						|| map[i][j] == 'y' || map[i][j] == 'z')
					{
						visited[nx][ny] = true;
						key[map[i][j] - 'a'] = true;
						q.push({ { nx,ny },numOfK });
					}
					else
					{
						if (key[map[i][j] - 'A'])
						{
							visited[nx][ny] = true;
							q.push({ { nx,ny },numOfK });
						}
					}
				}
			}
		}
	}
}
void init()
{
	ios_base::sync_with_stdio;
	cin.tie(NULL); cout.tie(NULL);

	cin >> w >> h;

	memset(visited, false, sizeof(visited));
	memset(key, false, sizeof(key));
	memset(map, '0', sizeof(map));

	for (int i = 0; i < w; i++)
	{
		for (int j = 0; j < h; j++)
		{
			cin >> map[i][j];
			if (i == 0 && j == 0 || i == 0 && j == h - 1 || i == w - 1 && j == 0 || i == w - 1 && j == h - 1)
			{
				if (map[i][j] != '*')
					ent.push_back({ i,j });
			}
		}
	}
	string s; cin >> s;
	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] == 'a' || s[i] == 'b' || s[i] == 'c' || s[i] == 'd'
			|| s[i] == 'e' || s[i] == 'f' || s[i] == 'g' || s[i] == 'h'
			|| s[i] == 'i' || s[i] == 'j' || s[i] == 'k' || s[i] == 'l'
			|| s[i] == 'm' || s[i] == 'n' || s[i] == 'o' || s[i] == 'p'
			|| s[i] == 'q' || s[i] == 'r' || s[i] == 's' || s[i] == 't'
			|| s[i] == 'u' || s[i] == 'v' || s[i] == 'w' || s[i] == 'x'
			|| s[i] == 'y' || s[i] == 'z')
			key[s[i] - 'a'] = true;
	}
}
int main()
{
	int T; cin >> T;
	for (int i = 0; i < T; i++)
	{
		init();

		int temp = 0;
		for (int j = 0; j < ent.size(); j++)
		{
			bfs(ent[j].first, ent[j].second);
			temp = max(answer, temp);
		}
		cout << temp;
	}
	return 0;
}
