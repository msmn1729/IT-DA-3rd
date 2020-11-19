#include <iostream>
#include <string>

using namespace std;

/*
    1의자리 수는 모두 팰린드롬
    10의자리 수는 -> 11, 22같은 수가 팰린드롬 -> 하지만 소수가 없다.
    100의자리 수 -> 101, 111, ...
*/

/*
    1. 소수인지 판별 -> 팰린드롬 판별?
    2. 팰린드롬 판별 -> 소수인지 판별?
*/

bool isPrimeNumber(int num)
{
    if (num < 2)
        return false;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return false;
    }

    return true;
}

bool isPalindrome(int num)
{
    string target = to_string(num);

    for (int i = 0; i < target.length() / 2; i++) {
        if (target[i] != target[target.length() - 1 - i]) {
            return false;
        }
    }

    return true;
}

int main(void)
{
    int N;

    cin >> N;
    while (true) {
        if (isPrimeNumber(N) && isPalindrome(N)) {
            cout << N << endl;
            break;
        }
        N++;
    }

    return 0;
}