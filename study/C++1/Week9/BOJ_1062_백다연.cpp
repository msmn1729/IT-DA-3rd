#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
string word[51];
bool visit[26];
int n, k;
int result;

void check(int eng, int cnt )
{
  if(cnt==k) //k개 다배움
  {
    int temp = 0;
    for(int i = 0; i < n; i++)
    {
      bool flag = true;
      for(int j = 0; j < word[i].length(); j++)
      {
        if(!visit[word[i][j] - 'a']) //안배운단어
        {
          flag = false;
          break;
        }
      }
        temp++;
    }
    result = max(result, temp);
    return;
    
  }

  for(int i = eng; i < 26; i++)
  {
    if(!visit[i]) //아직 k개를 다 배우지 않았고 방문하지 않았다면
      {
        visit[i] = true;
        check(i, cnt+1);
        visit[i] = false;

      }
  }
}

int main()
{
  cin >> n >> k;

  if( k < 5) // antic 모두 사용
  {
    cout << 0 << endl;
    return 0;
  }

  else if(k==26) //알파벳 모두 사용
  {
    cout << n << endl;
    return 0;
  }

  k -= 5; // antic  빼고 갯수 세기
  
  for(int i = 0 ; i < n; i++)
  {
      cin >> word[i];

      word[i] = word[i].substr(4,word[i].length()); // 접두사 빼고 저장
      
      for(int j = 0; j < 4; j++)
        word[i].pop_back();  //tica 빼기 
  }

  //무조건 포함
  visit['a'-'a'] = true;
  visit['c'-'a'] = true;
  visit['i'-'a'] = true;
  visit['n'-'a'] = true;
  visit['t'-'a'] = true;

  check(0,0);


  cout << result << endl;




  return 0;
}