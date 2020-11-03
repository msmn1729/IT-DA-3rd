#import sys
#input = sys.stdin.readline

n,s,m = map(int,sys.stdin.readline())

dp= [[0]*m+1 for i in range(n+1)]

dp[0][s] = 1

for i in range(1,n+1):
    for j in range(m+1):
        if dp[i-1][j] == 1 :
                if 0 <= j + v[i-1] <= m:
                    dp[i][j+v[i-1]] = 1
                if 0 <= j - v[i-1] <= 20:
                    dp[i][j-v[i-1]] = 1

max1 = max(dp[m-1])

print(max)



