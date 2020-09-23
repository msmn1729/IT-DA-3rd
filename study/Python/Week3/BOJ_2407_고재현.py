# 2407 조합

n, r = map(int, input().split()) 
ans = 1
for i in range(r):
    ans = ans * n
    n = n-1
    
ans2 = 1
for j in range(1,r+1) :
    ans2 = ans2 * j


print(ans//ans2)
