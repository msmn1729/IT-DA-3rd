#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int D, N;

int pizza[300100];
int findpizza, index;
vector <int> oven;
int now_index;


int binary_search(int val) {
	int first = 0; int last = now_index;
	while (first <= last) {
		int mid = (first + last) / 2;
		if (mid == 0) {
			return 0;
		}
		else if (oven[mid] >= val) { //피자가 오븐보다 작으면 
			if ((mid == first) or (mid == first + 1)) { //탐색 끝
				if (oven[last] >= val) { //마지막 오븐까지 피자보다 크면 아무데나 들어가도 ok니까
					return now_index;
				}
			}
			first = mid;

		}
		else if (oven[mid] < val) {  //피자가 오븐보다 크면
			if ((mid==first)or(mid==first+1)) {
				if (oven[mid - 1] >= val) { //앞 쪽에는 들어갈 수 있어야 되니까
					return mid; //거기서 걸리는거니까 
				}
				else { return 0; } //피자가 오븐보다 큰데 앞에도 못들어가면 못들어감
			}
			last = mid - 1;

		}
	}
}

int main()

{
	int k;
	int m  = 1000000000;

	cin >> D >> N;
	for (int i = 0; i < D; i++) {
		cin >> k;
		if (k > m) {
			oven.push_back(m);
		}
		else {
			oven.push_back(k);
			m = k;
		}
	}
	now_index = (sizeof(oven)-1)/2-1;
	for (int i = 0; i < N; i++) {
		cin >> pizza[i];
		findpizza = binary_search(pizza[i]);
		now_index = findpizza - 1;
	}

	cout << now_index + 1;
}


