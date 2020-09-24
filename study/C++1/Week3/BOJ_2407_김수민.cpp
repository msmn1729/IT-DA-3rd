#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <stdlib.h>

using namespace std;
int n, m;
string result[101][101];

string add(string v1, string v2) {
	int total=0;
	string result;
	int v1_idx = v1.size() - 1;
	int v2_idx = v2.size() - 1;
	while (v1_idx>=0 || v2_idx>=0 || total) {
		if (v1_idx >= 0) {
			total += v1[v1_idx--] - '0';
		}
		if (v2_idx >= 0) {
			total += v2[v2_idx--] - '0';
		}
		int digit = total % 10;
		total = total / 10;
		result += digit + '0';
	}
	reverse(result.begin(), result.end());
	return result;
}

string nCm(int a, int b) {
	if (a <= 0) { return "0"; }
	if ((b == 0) or (a == b)) { return "1"; }

	if (b == 1) {
		return to_string(a);
	}
	if (a - b < b) { b = a - b; } //ex. 100C98이면 100C2로
	if (result[a][b].size()) {
		return result[a][b];
	}
	return result[a][b] = add(nCm(a - 1, b - 1), nCm(a - 1, b)); //nCm = n-1Cm-1 + n-1Cm
}
int main()
{
	cin >> n >> m;
	
	cout << nCm(n,m);
}
