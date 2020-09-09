#include<iostream>
using namespace std;
//a<b일때만 작동되기 때문에 입력 받을때 a<b가 되게 강제함
int main(void) {
	int n, m;
	int fri[501][500] = { {0} };
	int f, s, j, count = 0, i, k = 0;
	int tmp[500] = { 0 }, tmp2[500] = { 0 };
	int tmp1, t = 0;
	cin >> n;
	cin >> m;
	for (i = 0; i < m; i++) {
		j = 0;
		cin >> f >> s;
		if (f > s) {
			tmp1 = f;
			f = s;
			s = tmp1;
		}t = 1;
		while (fri[f][j] != 0) {
			if (fri[f][j] == s) {
				t = 0;
				break;
			}
			j++;
		}
		if (t) {
			fri[f][j] = s;
		}
	}
	j = 0;
	f = 0;
	while (fri[1][j] != 0) {
		tmp2[f++] = tmp[j++] = fri[1][j];
		count++;
	}
	k = i = s = 0;
	for (i = 0; i < j; i++) {
		k = 0;
		bool a = true;
		while (fri[tmp[i]][k] != 0) {
			f = 0;
			while (tmp2[f] != 0) {
				if (fri[tmp[i]][k] == tmp2[f]) {
					a = false;
					break;
				}
				f++;
			}
			if (fri[tmp[i]][k] != 0 && a) {
				count++;
				tmp2[s] = fri[tmp[i]][k];
				s++;
			}
			k++;
		}
	}
	cout << count;
	return 0;
}