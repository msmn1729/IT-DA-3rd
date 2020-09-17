/*
#include <iostream>
using namespace std;


int N;

//소수 판별
int prime(int num) {

    //if(num == 1 || num == 0)

    for (int i = 2; i < num; i++) {
        if (num % i == 0)
            return 0;
    }
    return 1;

}


void dfs(int first, int n) {
    if (n == N) {
        cout << first << "\n";
        return;
    }
    else {
        for (int i = 1; i <= 9; i++)
        {
            if (prime(first * 10 + i) == 1)
            {
                dfs(first * 10 + i, n + 1);
            }
        }
    }


}

int main()
{
    cin >> N;
    
    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);

}



//첫째 자리는 무조건 2,3,5,7
//나머지 자리는 홀수가 되어야 한다. 짝수가 되면 신기한 숫자의 조건을 만족할 수 없다.
*/