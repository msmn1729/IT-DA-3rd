#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef struct {
	int paper;
	int interview;
}S;

vector <int> ans;
int T, N;

bool compare(S a, S b) {
	if (a.paper == b.paper) {
		return a.interview < b.interview;
	}
	else {
		return a.paper < b.paper;
	}
}

int main()
{
	int a, b;
	cin >> T;
	int people;
	while (T) {

		vector <S> v;
		bool visited[1000] = {false};
		cin >> N;
		people = N;
		for (int i = 0; i < N; i++) {
			cin >> a >> b;

			v.push_back({ a,b });
		}
		sort(v.begin(), v.end(), compare);
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if ((v[i].interview < v[j].interview)&&(visited[j]!=true)) {
					visited[j] = true;
					people--;
				}
			}
			
		}
		cout << people<<"\n";
		T--;
	}
	
}
