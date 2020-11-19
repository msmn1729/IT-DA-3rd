#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, K;
vector <int> v;

int main()

{
	string num;
	cin >> N >> K;
	cin >> num;
	int cnt = K;
	for (int i = 0; i < N; i++) {
		while ((!v.empty())&&(cnt>0)&&(v.back() < num[i] - '0')) { //끝에 숫자가 넣을 숫자보다 작으면 큰 숫자 만날때 까지 빼준다
			v.pop_back();
			cnt--;
		}
		v.push_back(num[i] - '0');
	}
	for (int i = 0; i < N - K; i++) {
		cout << v[i];
	}
 
}
