#14002번
#최장증가수열(LIS 수열)
# 다시 풀어보기
n = int(input())
a = [0]+list(map(int, input().split()))
DP = [0]*(n+1)
 
for i in range(1,n+1):
    for j in range(1, i, 1):
        if a[i] > a[i-j]:
            DP[i] = max(DP[i-j], DP[i])
    DP[i] += 1
print(max(DP))
