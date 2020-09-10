from collections import deque
n, m, k = map(int, input().split())
a = [[0]*m for _ in range(n)]
visited = [[False]*m for _ in range(n)]
dirX = [1,-1,0,0]
dirY = [0,0,-1,1]
ans = 0

def bfs(i,j):
    q = deque()
    q.append((i,j))
    cnt = 1
    visited[i][j] = True
    while q:
        x, y = q.popleft()
        for z in range (4):
            nx, ny = x+dirX[z], y+dirY[z]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if a[nx][ny] == 1 and visited[nx][ny] == False:
                q.append((nx,ny))
                
                visited[nx][ny] = True
                cnt += 1

    return cnt
            
    
    

for _ in range(k):
    r,c = map(int, input().split())
    a[r-1][c-1] = 1 # 장애물 표시

for i in range(n):
    for j in range(m):
        if a[i][j] == 1 and visited[i][j] == False:# 장애물이 존재하고 아직 확인 안한 좌표중에
            ans = max(ans, bfs(i,j))

print(ans)
