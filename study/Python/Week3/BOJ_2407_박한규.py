import sys
input = sys.stdin.readline

def fact(num):
    if num == 1:
        return 1
    return num * fact(num - 1)

def main():
    n, m = map(int, input().split())
    m_fact = fact(m)
    n_m_fact = fact(n - m)
    n_fact = fact(n)
    print(n_fact // (m_fact * n_m_fact))

main()
