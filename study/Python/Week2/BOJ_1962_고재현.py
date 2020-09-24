from collections import deque
import sys
input = sys.stdin.readline
n,m = map(int, input().split())
s = [list(map(int, input().split())) for i in range(n)]
visit = [[0] * m for i in range(n)]


dx = [0,0,1,-1]
dy = [1,-1,0,0]
ans = 0

def bfs(i,j):
    q = deque()
    q.append((i,j))
    visit[i][j] = 1
    cnt = 1 #

    while q:
        x,y = q.popleft()
        for z in range (4):
            nx, ny = x + dx[z], y+dy[z]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if s[nx][ny] == 1 and visit[nx][ny] == 0:
                q.append((nx,ny))
                visit[nx][ny] = 1
                cnt += 1

    return cnt

result = 0
for i in range(n):
    for j in range(m):
        if s[i][j] ==  1 and visit[i][j] == 0:
            result += 1
            ans = max(ans,bfs(i,j))
            
print(result)
print(ans)
            
    

