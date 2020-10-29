#시간 초과
#최장 증가 수열 응용
#다시 풀어보기 
n = int(input())
a = [0]+list(map(int, input().split()))
DP = [0]*(n+1)
 
for i in range(1,n+1):
    for j in range(1, i, 1):
        if a[i] > a[i-j]:
            DP[i] = max(DP[i-j], DP[i])
    DP[i] += 1
print(n-max(DP))
