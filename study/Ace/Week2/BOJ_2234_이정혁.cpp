#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std;

vector<pair<int, int>> v[17];

int n, m, room, maxroom = -1, roomwidth, overroom;
int arr[101][101];
bool visit[101][101];
vector<pair<int,int>> width;
queue<pair<int, int>> q;
pair<int,int> value[101][101];
// 1. 방의 갯수, 2. 가장 넓은 방의 크기 3. 벽 하나 뿌수고 얻을 수 있는 가장 넓은 방의 크기.
typedef struct {
	int x;
	int y;
} Current;
void makemoving() { // 움직이는거 저장
	v[15].push_back({ 0,0 });
	v[14].push_back({ 0,-1 });
	v[13].push_back({ -1,0 });
	v[12].push_back({ 0,-1 });
	v[12].push_back({ -1,0 });
	v[11].push_back({ 0,1 });
	v[10].push_back({ 0,-1 });
	v[10].push_back({ 0,1 });
	v[9].push_back({ -1,0 });
	v[9].push_back({ 0,1 });
	v[8].push_back({ 0,-1 });
	v[8].push_back({ -1,0 });
	v[8].push_back({ 0,1 });
	v[7].push_back({ 1,0 });
	v[6].push_back({ 0,-1 });
	v[6].push_back({ 1,0 });
	v[5].push_back({ -1,0});
	v[5].push_back({ 1,0 });
	v[4].push_back({ 0,-1 });
	v[4].push_back({ -1,0 });
	v[4].push_back({ 1,0 });
	v[3].push_back({ 0,1 });
	v[3].push_back({ 1,0 });
	v[2].push_back({ 0,1 });
	v[2].push_back({ 1,0 });
	v[2].push_back({ -1,0 });
	v[1].push_back({ 1,0 });
	v[1].push_back({ 0,1 });
	v[1].push_back({ -1,0 });
	v[0].push_back({ 0,1 });
	v[0].push_back({ 1,0 });
	v[0].push_back({ -1,0 });
	v[0].push_back({ 0,-1 });
}
void bfs(int x, int y) {
	roomwidth = 1;
	q.push({ x,y });
	visit[x][y] = true;
	width.push_back({ x,y });
	while(!q.empty()) {
		Current current;
		current.x = q.front().first;
		current.y = q.front().second;
		q.pop();
		for (int i = 0; i < v[arr[current.x][current.y]].size();i++) {
			int nx = current.x + v[arr[current.x][current.y]][i].first;
			int ny = current.y + v[arr[current.x][current.y]][i].second;
			if (nx > 0 && nx <= m && ny > 0 && ny <= n && visit[nx][ny] == false) {
				roomwidth++; // 룸 크기 측정
				visit[nx][ny] = true;
				width.push_back({ nx,ny }); // 연결되어 있는 방을 같은 번호로 연결해주기 위해서
				q.push({ nx,ny });
			}
		}
	}
}
int main(void) {
	cin >> n >> m;
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
		}
	}
	makemoving();
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			if (visit[i][j] == true) { // 방문되어 있으면 스킵
				continue;
			}
			width.clear();
			room++; // 룸 갯수 ++
			bfs(i, j);
			for (int k = 0; k < width.size(); k++) { // 연결되어 있는 방
				value[width[k].first][width[k].second].first = roomwidth; // 연결되어 있는 방은 전부 같은 값 너어주기
				value[width[k].first][width[k].second].second = room; // 방번호 붙이기
			}
			maxroom = max(maxroom, roomwidth); // 룸 크기 젤 큰거로 반환
		}
	}

	overroom = maxroom; // 다 뚫려 있거나 방의 갯수가 1개 일수도 있으므로 

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j < n; j++) {
			if (value[i][j].second == value[i][j + 1].second) { // 방 번호 같으면 스킵
				continue;
			}
			else { // 방 번호 다르면
				overroom = max(value[i][j].first + value[i][j + 1].first,overroom); // x축 쪽으로 이동하면서 모든 방 번호가 다를경우 두 방의 value 더해줘서 max 값 찾기
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j < m; j++) {
			if (value[j][i].second == value[j + 1][i].second) { // 방 번호 같으면 스킵
				continue;
			}
			else { //방 번호가 다르면
				overroom = max(value[j][i].first + value[j + 1][i].first, overroom);// y축 쪽으로 이동하면서 모든 방 번호가 다를경우 두 방의 value 더해줘서 max 값 찾기
			}
		}
	}
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			cout << value[i][j].second << ' ';
		}
		cout << '\n';
	}
	cout << room << '\n' << maxroom << '\n' << overroom;
	return 0;
}