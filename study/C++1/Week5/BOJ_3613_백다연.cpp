#include <iostream>
#include <queue>
#include <vector>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
vector<int> under;
vector<int> cap;

int main()
{
  string s;
  cin >> s;


  if(s[0] < 97 || s[0] == '_' || s[s.size()-1] == '_'){  // 대문자, 언더바
    cout << "Error!" << endl;
    return 0;
  }

  //두번째부터 탐색
  for(int i = 1; i < s.size(); i++ )
  {
      if(s[i] == '_')
        under.push_back(i);
      if(s[i] < 97)
        cap.push_back(i);
  }

  if(under.size() == 0 && cap.size() == 0)
    {
      cout << s << endl;
      return 0;
    }
  else if(under.size() != 0 && cap.size() != 0) //둘다 존재하면 안됨
  {
    cout << "Error!" << endl;
    return 0;
  }
  else if(under.size()!=0) //언더바 존재하면 씨쁠형태
  {
    int preindex = under[0];
    for(int i = 1; i < under.size(); i++)
    {
      if (under[i] - preindex == 1)
      { 
        cout << "Error!";
        return 0;
      }
      preindex = i;
    }

    int count = 0;
    for (int i = 0; i < under.size(); i++)
    {
      s.erase(i - count, 1);
      s.replace(i - count, 1, 1, s[i - count] - 32); //대문자로 변경
      count++;
    }
  }

  else if(cap.size() != 0) 
  {
    int count = 0;
    for (int i = 0; i < cap.size(); i++)
    {
      s.replace(i + count, 1, 1, s[i + count] + 32);
      s.insert(i + count, 1, '_');
      count++;
    }
  }

  cout << s << endl;

  return 0;
}
