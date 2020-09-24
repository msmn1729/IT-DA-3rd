from collections import deque

def bfs(a,b):
    q = deque()
    q.append([a,b])
    #넓이 처음 들어갈때 1로 시작한다...
    #is_pictures[a][b] = True
    #area = 0일때도 결과는 똑같은데 틀리게 나옴
    pictures[a][b] = 0; area = 1
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m:
                #아직 접근하지 않았다면
                if pictures[nx][ny]==1:
                    #is_pictures[nx][ny] = True
                    pictures[nx][ny] = 0
                    q.append([nx,ny])
                    area = area+1
    return area

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

n,m = map(int, input().split())
cnt = 0; maximum=0
pictures = [list(map(int, input().split())) for i in range(n)]
#is_pictures = [[0] * m for i in range(n)]
for i in range(n):
        for j in range(m):
            if pictures[i][j]:  # 한번 들어갈 때마다 그림 +1
                maximum = max(maximum,bfs(i, j))
                #2234번 참고
                cnt += 1
print(cnt)
print(maximum)