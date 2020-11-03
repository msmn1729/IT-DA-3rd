#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;

int main()
{
  int T;
  cin >> T;

  int N,M;
  int a,b;
  while(T--)
  {
    cin >> N >> M;

    for(int i = 0; i < M; i++)
    {
      cin >> a >> b;
    }

    cout << N-1 << endl;
  }
  

  return 0;
}
