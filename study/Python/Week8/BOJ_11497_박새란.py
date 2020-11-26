import sys
t = map(int, sys.stdin)

for _ in range(t):
    n = int(input())
    x = list(map(int, sys.stdin.readline().split()))
    x.sort()
    result = 0
    for i in range(2,n):
        temp = x[i] - x[i-2]
        result = max(result, temp)
    print(result)