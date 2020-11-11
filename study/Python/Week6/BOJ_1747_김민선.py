#1. 소수여야 한다 (에라토스테네스의 체)
#2. 숫자를 뒤집어도 같은 수 (팰린드롬 수) 여야 한다 (문자열 이용)
import sys

def isprime():
    a = [False,False] + [True]*(maximum-1)
    for i in range(2,maximum+1):
        if a[i]:
            for j in range(2*i, maximum+1, i):
                a[j] = False
    return a

def ispal(string):
    s = str(string)
    if s == s[::-1]:
        return True
    else:
        return False

N = int(input())
#얘.....
maximum = 1003001
prime = isprime()
for i in range(N,maximum+1):
    if prime[i] and ispal(i):
        print(i)
        sys.exit()
print(maximum)