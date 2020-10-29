a = list(map(int, input().split()))
n,m = a[0],a[1]
k = a[2:]
dp = [[0 for _ in range(m)] for _ in range(n)] #[x][y] 해당 격자점에 대한 최단경로수

def sol(x1,y1):
    for x in range(x1+1):
        for y in range(y1+1):
            if x == 0 or y == 0: #가장자리 최단 경로수
                dp[x][y] = 1 
            if dp[x][y] == 0:
                if dp[x-1][y] != 0:
                    dp[x][y] += dp[x-1][y]
                if dp[x][y-1] != 0:
                    dp[x][y] += dp[x][y-1]
    return dp[x1][y1] 

total = 1
start = [0,0]
if(k[0]!=0):
    for spot in k:
        #k[i]값에 대한 격자점으로 변환
        end = [spot//m,spot%m-1]

        #k[i], k[i+1]값에 대한 격자
        x = end[0]-start[0]
        y = end[1]-start[1]
        total *= sol(x,y)

        #start갱신
        start = end.copy()



total *= sol(n-1-start[0], m-1-start[1])
print(total)
    

