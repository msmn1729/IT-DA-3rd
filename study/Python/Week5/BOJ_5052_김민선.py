#시간 초과
#였는데 zip함수랑 sys써서 맞음
import sys

def isstart(number):
    number.sort()
    for i, j in zip(number,number[1:]):
        if i == j[:len(i)]:
            return 'NO'
    return 'YES'

t = int(sys.stdin.readline())
res = ''
for i in range(t):
    n = int(sys.stdin.readline())
    call = [0 for i in range(n)]
    for j in range(n):
        call[j] = sys.stdin.readline().rstrip('\n')
    res = isstart(call)
    print(res)