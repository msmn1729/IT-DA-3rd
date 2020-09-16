//신기한 소수

#include <iostream>
using namespace std;


int N;

bool check(int now)
{
    if(now == 0 || now == 1) //0이나 1이면 소수x
        return false;

    for(int i = 2; i*i <=now; i++)
        if(now % i == 0)
            return false;

    return true;
     
}

//현재 수와 길이를 변수로
void dfs(int num, int len)
{
    
    if(len == N)
    {
        cout << num << endl;
        return;
    }
                
        
    for(int i = 1; i <= 9; i+=2)
    {
        if(check(num*10 + i)) //소수이면
            dfs(num*10 + i, len + 1);
    }
    
    

}


int main()
{
    cin >> N;
    
    //맨앞에 2,3,5,7, 가능
    
    dfs(2,1);
    dfs(3,1);
    dfs(5,1);
    dfs(7,1);
    
    return 0;
        
}
