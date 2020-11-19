#include <iostream>
#include <stack>
#include <string>
#include <stdio.h>
using namespace std;
char str[500001];
stack<char>st;
stack<char>result;
int main() {
	int N, K;
	cin >> N >> K>>str;
	for (int i = 0; i < N; i++)
	{
		while (K != 0 && !st.empty() && st.top() < str[i])
		{
			st.pop();
			K--;
		}
		if(st.size()<N-K)
			st.push(str[i]);
	}
	while (!st.empty())
	{
		result.push(st.top());
		st.pop();
	}
	while (!result.empty())
	{
		cout << result.top();
		result.pop();
	}
}