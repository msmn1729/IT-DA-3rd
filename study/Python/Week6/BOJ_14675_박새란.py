import sys

n = int(input())
x = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int,input().split())
    x[a].append(b)

q = int(input())
for _ in range(q):
    t,k = map(int, input().split())
    if(t == 2):
         print("yes")
    else:
        cnt = 0
        for i in range(n+1):
            if i == k:
                cnt+=len(x[i])
            elif k in x[i]:
                cnt+=1
        if cnt >= 2:
            print("yes")
        else:
            print("no")
        
