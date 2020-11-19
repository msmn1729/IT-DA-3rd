#include <iostream>
#include <string>
using namespace std;

int main() {
	int N, M,count=0;
	string S;
	cin >> N >> M >> S;

	int j = 0, tmp=0;
	for (int i = 0; i < S.length()-2; i++)
	{
		if (S[i] == 'I')
		{
			while (S[i + 1] == 'O' && S[i + 2] == 'I')
			{
				tmp++;
				if (tmp == N)
				{
					tmp--;
					count++;
				}
				i += 2;
				
			}
			tmp = 0;
		}
	}
	cout << count;
}