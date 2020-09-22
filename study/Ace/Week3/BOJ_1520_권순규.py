import sys
M, N = 0,0
Map = []
dp = []
dx, dy = [1,-1,0,0],[0,0,-1,1]

def dfs(y,x):
    if [y,x] == [1,1]:
        return 1
    
    if dp[y][x] != -1:
        return dp[y][x]
    
    dp[y][x] = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if Map[ny][nx] and Map[ny][nx] > Map[y][x]:
            dp[y][x] += dfs(ny,nx)
    
    return dp[y][x]

if __name__ == "__main__":
    M, N = map(int,input().split())
    Map = []
    dp = [[-1 for _ in range(N+2)] for _ in range(M+2)]
    Map.append([0 for _ in range(N+2)])
    for _ in range(M):
        Map.append([0] + list(map(int,sys.stdin.readline().split())) + [0])
    Map.append([0 for _ in range(N+2)])

    print(dfs(M,N))
