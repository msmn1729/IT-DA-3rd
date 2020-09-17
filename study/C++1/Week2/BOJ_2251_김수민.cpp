#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int amount[3]; //물통의 부피
int water[3]; //물의 양
bool check[201][201];
int sum;
vector <int> C; //답

void bfs() {
	queue <pair<int, int> > q;
	q.push(make_pair(0, 0));
	
	while (!q.empty()) {
		water[0] = q.front().first;
		water[1] = q.front().second;
		water[2] = sum - water[0] - water[1];
		q.pop();
		if (check[water[0]][water[1]] == true) continue;
		check[water[0]][water[1]] = true;

		if (water[0] == 0) { C.push_back(water[2]); }

		for (int i = 0; i < 3; i++) { //A->B, B->C, C->A
			int temp[3] = { water[0],water[1],water[2] };

			if (temp[i] + temp[(i + 1)%3] > amount[(i + 1)%3]) { //다 부우면
				temp[i] = temp[i] + temp[(i + 1) % 3] - amount[(i + 1) % 3]; //옮기는 쪽
				temp[(i + 1) % 3] = amount[(i+1)%3]; //담기는 쪽
				q.push(make_pair(temp[0], temp[1]));
				
			}
			else { //다 붓는게 아니면
				temp[(i + 1) % 3] =temp[i] + temp[(i + 1) % 3];
				temp[i] = 0;
				q.push(make_pair(temp[0], temp[1]));
			
			}
		
		}
		for (int i = 6; i > 3;i--) { //A->C, C->B, B->A
			int temp[3] = { water[0],water[1],water[2] };

			if (temp[i % 3] + temp[(i - 1) % 3] > amount[(i - 1) % 3]) {
				temp[i % 3] = temp[i % 3] + water[(i - 1) % 3] - amount[(i - 1) % 3];
				temp[(i - 1) % 3] = amount[(i - 1) % 3];
				q.push(make_pair(temp[0], temp[1]));
				
			}
			else {
				temp[(i - 1) % 3] =temp[i % 3] + temp[(i - 1) % 3];
				temp[i % 3] = 0;
				q.push(make_pair(temp[0], temp[1]));

			}
			
		}
		


	}
}



int main()
{
	for (int i = 0; i < 3; i++) {
		cin >> amount[i];
	}
	sum = amount[2];
	bfs();
	sort(C.begin(), C.end());
	for (int i = 0; i < C.size(); i++) {
		cout << C[i] << " ";
	}
	return 0;
}
