//#include<iostream>
//#include<string>
//#include<vector>
//#include<algorithm>
//using namespace std;
//
//
//int main() {
//
//	int tn;
//	int num;
//	int first;
//	int second;
//	bool result = true;
//	char st[10001];
//	vector<string> v;
//
//	cin >> tn;
//
//	for (int i = 0; i < tn; i++) {
//
//		cin >> num;
//		for (int j = 0; i < num; j++) {
//			cin >> st[i];
//			v.push_back(st);
//		}
//
//		sort(v.begin(), v.end());
//
//
//		//k¹øÂ°¶û k+1 ¹øÂ°¶û ºñ±³
//		for (int k = 1; k < num; k++)
//		{
//			first = v[k].length();
//			second = v[k + 1].length();
//			if (first >= second)
//				continue;
//			if (v[k + 1].substr(0, first) == v[k]) {
//				cout << "NO" << endl;
//				result = false;
//				break;
//			}
//
//
//		}
//
//		if (result == true)
//			cout << "YES" << endl;
//	}
//
//}