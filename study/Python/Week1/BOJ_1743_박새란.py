from collections import deque

n,m,k = map(int,input().split())
a = [[0]*m for _ in range(n)] 
visit = [[0] * m for _ in range(n)]
result = 0

def bfs(i,j):
    q = deque()
    q.append((i,j))
    visit[i][j] = 1
    count = 1
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y +dy[i]
            if nx < 0 or nx>=n or ny <0 or ny >= m:
                continue
            if not visit[nx][ny] and a[nx][ny]:
                q.append((nx,ny))
                visit[nx][ny] = 1
                count += 1
    return count  


for _ in range(k):
    p,q = map(int,input().split())
    a[p-1][q-1] = 1
for i in range(n):
    for j in range(m):
        if a[i][j]:
            result = max(result,bfs(i,j))
        
print(result)
        
