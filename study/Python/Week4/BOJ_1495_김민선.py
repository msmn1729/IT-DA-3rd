def dp(start,volume):
    p = start
    if 1<= p+volume <= m :
        p += volume
    if 1<= p-volume <= m:
        p -= volume
        #재귀..?
    return p

n,s,m = list(map(int,input().split()))
v = list(map(int,input().split()))
lst = [0 for i in range(n*2)]
c = 0
for i in range(n):
    c = dp(s,v[i])
if c < 0 : print(-1)
else : print(c)