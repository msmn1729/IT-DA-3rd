n = int(input())

# 1과 00만 존재
# 이진 수열 경우의수
dp = [0 for _ in range(n+1)]
def binary_seq(n):
    if n < 2:
        return 1
    if( dp[n] == 0 ):
        dp[n] = binary_seq(n-1) + binary_seq(n-2)
    return dp[n]
    
print(binary_seq(n))
