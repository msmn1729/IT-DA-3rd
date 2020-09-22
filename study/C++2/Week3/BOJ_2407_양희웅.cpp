#include <iostream>
#include <iomanip>

using namespace std;

int n, m;
const long long maximum = 1e17;

struct BigNum
{
    unsigned long long front = 0;
    unsigned long long rear = 0;
};

BigNum operator+(BigNum a, BigNum b)
{
    BigNum result;
    result.front = a.front + b.front;

    if (a.rear + b.rear > maximum) {
        cout << "+ if" << endl;
        result.rear = a.rear + b.rear - maximum;
        result.front++;
    }
    else {
        cout << "+ else" << endl;
        result.rear = a.rear + b.rear;
    }

    return result;
}

bool operator!=(BigNum a, BigNum b)
{
    if ((a.front == b.front) && (a.rear == b.rear)) 
        return false;
    
    return true; 
}

void printBigBum(BigNum bn)
{
    if (bn.front == 0) {
        cout << bn.rear << endl;
    }
    else {
        cout << bn.front << setfill('0') << setw(sizeof(unsigned long long)) << bn.rear << endl;
    }
}

BigNum BC[101][101] {};

BigNum getBC(int n, int m)
{
    if (m == 0 || n == m) {
        BC[n][m].rear = 1;
        return BC[n][m];
    }
    if (BC[n][m] != BigNum{0, 0}) {
        return BC[n][m];
    }
    BC[n][m] = getBC(n - 1, m - 1) + getBC(n - 1, m);

    return BC[n][m];
}

void solve()
{
    BigNum result = getBC(n, m);
    if (result.front != 0) {
        cout << result.front;
    }
    cout << result.rear << endl;
}

void input()
{
    cin >> n >> m;
}

int main(void)
{
    input();
    solve();

    return 0;
}