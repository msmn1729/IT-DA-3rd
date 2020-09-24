#include<iostream>
#include<algorithm>
using namespace std;

//조합 : nCr = n-1Cr-1 + n-1Cr
//큰 수를 더할 때는 string 으로 바꾼 다음 계산

//setting
string com[101][101];

//큰 수 계산(블로그 참고) -- 외워놔야지..
string add(string n, string m) {
	string result;
	long long int s;
	while (!n.empty() || !m.empty() || s) {
		if (!n.empty())
		{
			s = s + n.back() - '0';
			n.pop_back();
		}
		if (!m.empty())
		{
			s = s + m.back() - '0';
			m.pop_back();
		}

		result.push_back((s % 10) + '0');
		s = s / 10;

	}
	reverse(result.begin(), result.end());
	return result;
}

string dp(int n, int r) {
	if (n == r || r == 0)
		return "1";
	/*if (dp(n,r) == "")
		return dp(n,r);*/
	return com[n][r] = add(dp(n - 1,r - 1), dp(n - 1,r));
}

int main() {
	int N, M;
	cin >> N >> M;
	cout << dp(N, M);
}

//시간 초과, 메모리초과