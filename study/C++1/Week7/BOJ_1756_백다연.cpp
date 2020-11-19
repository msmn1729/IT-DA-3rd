#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
#include <string.h>
#include <string>
#include <utility>
#include <algorithm>

using namespace std;
 int D,N; //오븐의 깊이, 피자 반죽개수
 long long oven[300001];
 //long long pizza[300001];

long long ovenwidth = 1000000001;

int main()
{
  cin >> D >> N;
  int deep = D;
  for(int i = 1; i <=D; i++)
  {
      long long width;
      cin >> width;
      ovenwidth = min(width, ovenwidth); // 전꺼가 다음보다 작으면 작은값 저장
      oven[i] = ovenwidth;
      
  }
int pizza = 0;
int floor = D+1;
int befor;
 while(N--)
 {
   befor = pizza;
   cin >> pizza;

   if(!floor)
    continue;

   if(pizza <= befor)// 전꺼보다 작거나 같으면 위층으로
   {
      floor--;
      continue;
   }
   int left = 0; 
   int right = floor-1;

   while(left <= right)
   {

     int mid = (left + right) /2;
     if(pizza <= oven[mid]) //현재탐색하는 지름과 피자비교
     {
       floor = mid;
       left = mid + 1;
      
     }
     else
     {
       right = mid-1;
     }
     
   }
 }
  cout << floor << endl;

  return 0;
}

