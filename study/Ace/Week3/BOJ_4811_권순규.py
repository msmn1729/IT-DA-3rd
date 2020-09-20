comment = '''
dp[2*j] : j일이 지났을 때 가능한 문자열의 개수-> 길이가 2j일때 가능한 문자열의 개수
j일이 지났을 때 문자열의 길이는 2j가 된다.
W다음에는 언젠가 반드시 H가 와야 하고 W와 H의 개수는 같아야 한다
W ..(1).. H ..(2)..
따라서 ..(1).. 의 길이를 j-2라 하면 (2)의 길이는 (문자열 길이-j)라 할 수 있다.
그러므로 점화식은 시그마(dp[j-2]*dp[N-j]), 2 <= j <= N, j는 짝수
'''

dp = [-1] * 5001

def go(n):
    if n == 0:
        return 1
    if dp[n] >= 0:
        return dp[n]
    dp[n] = 0
    for i in range(2,n+1,2):
        dp[n] += go(i-2) * go(n-i)

    return dp[n]

if __name__ == "__main__":
    while True:
        N = int(input())
        if N == 0:
            break
        
        dp[2] = 1
        print(go(2*N))