import sys
read = sys.stdin.readline

n = int(read())
children = list(map(int, read().split()))
dp = [0 for _ in range(n+1)]
for i in range(n):
    a = children[i]
    dp[a] = dp[a-1]+1
print(n-max(dp))
