T = int(input())
res = [0 for i in range(T)]
for i in range(T):
    N = int(input())
    L = list(map(int,input().split()))
    L.sort()
    for j in range(N-2):
        res[i] = max(res[i],abs(L[j]-L[j+2]))

for i in range(T):
    print(res[i])