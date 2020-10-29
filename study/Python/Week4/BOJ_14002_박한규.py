n = int(input())
a = list(map(int, input().split()))
dp = [1 for i in range(n)]
arr = [[x] for x in a]

for i in range(n):
    for j in range(i):
        if a[i] > a[j] and dp[j] + 1 > dp[i]:
            arr[i] = arr[j] + [a[i]]
            dp[i] = dp[j] + 1

print(max(dp))
print(*arr[dp.index(max(dp))])


