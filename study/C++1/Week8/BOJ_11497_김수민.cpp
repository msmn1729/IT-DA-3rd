#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int N,T;

int main()
{
	int k; int mid;

	cin >> T;
	while (T) {
		vector <int> a;
		int arr[10001];
		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> k;
			a.push_back(k);
		}
		sort(a.begin(), a.end());
		mid = N / 2;
		arr[mid] = a.back();
		a.pop_back();

		for (int i = 1; i <= mid; i++) {
			if ((N % 2 == 0) & (i == mid)) { arr[mid - i] = a.back(); a.pop_back(); continue; }
			arr[mid + i] = a.back();
			a.pop_back();
			arr[mid - i] = a.back();
			a.pop_back();
		}
		for (int i = 0; i < N - 1; i++) {
			if (arr[i + 1] > arr[i]) { a.push_back(arr[i + 1] - arr[i]); }
			else { a.push_back(arr[i] - arr[i + 1]); }

		}
		a.push_back(arr[N - 1] - arr[0]);
		sort(a.begin(), a.end());

		cout << a.back()<<"\n";
		T--;
	}
}
