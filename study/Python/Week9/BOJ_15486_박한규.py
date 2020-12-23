import sys
read = sys.stdin.readline

N = int(read())

day = N
T, P = [], []
dp = [0] * (N + 1)

for i in range(N):
    tmp = list(map(int, read().split()))
    T.append(tmp[0])
    P.append(tmp[1])

for i in range(N):
    if T[i] <= N - i:
        dp[i + T[i]] = max(dp[i + T[i]], dp[i] + P[i])
    dp[i + 1] = max(dp[i + 1], dp[i])

print(dp[N])