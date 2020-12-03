import sys

t = []; p = []
n = int(sys.stdin.readline())
dp = [0]*(n+1)

for i in range(n):
    first_t, first_p = list(map(int, sys.stdin.readline().split()))
    t.append(first_t); p.append(first_p)

for i in range(n):
    if i+t[i] <= n:
        dp[i+t[i]] = max(dp[i+t[i]],dp[i]+p[i]) 
    dp[i+1] = max(dp[i+1],dp[i])

print(dp[n])

#https://hapbbying.tistory.com/15 참고