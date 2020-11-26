import sys
sys.setrecursionlimit(10**9)
t = int(input())

for _ in range(t):
    n,m = map(int, sys.stdin.readline().split())
    a = list(map( int, sys.stdin.readline().split()))
    b = list(map( int, sys.stdin.readline().split()))
    count = 0
    for i in range(n):
        for j in range(m):
            if(a[i] > b[j]):
                count+=1
            else:
                break
    print(count)
    
