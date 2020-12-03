#15486

import sys

N = int(input())
T, P = [], []
dp = [0]*(N+1) 

for i in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    T.append(temp[0])
    P.append(temp[1])

cmax = 0
for i in range(0, N):
    cmax = max(cmax,dp[i])
    if T[i] > N - i:
        continue
    
    dp[i+T[i]] = max(cmax+P[i], dp[i+T[i]])
    # i번쨰에 일을 선택해서 t[i]까지 한 값 = max(i뻔째까지 와서 번 돈의 최댓값+현재 i번째 일을 할 경우, 일을 안하고 넘어갈 경우)

print(max(dp))
