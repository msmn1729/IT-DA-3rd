from sys import stdin
from collections import deque
input = stdin.readline

dx = (-1, 0, 1, 0, 2, 1, -1, -2, -2, -1, 1, 2)
dy = (0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1)
k = int(input())
w, h = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(h)]
d = [[[0]*(k+1) for _ in range(w)] for _ in range(h)]


def bfs():
    q = deque()
    q.append((0, 0, 0)) #시작파트
    while q:
        x, y, z = q.popleft() # 시작점으로 만드려고 넣은 (nx,ny,nz)가 x,y,z가 되기 위해서  뽑아냄
        j = 4 if z == k else 12 # 말처럼 이동하는 걸 다 썼으면 4만 반복
        if x == h-1 and y == w-1: #도착했을 경우
            print(d[x][y][z]) 
            return 
        for i in range(j):
            nx, ny = x+dx[i], y+dy[i] # 이동
            nz = z if i < 4 else  z+1 # 원숭이처럼 이동했으면 z 안늘리고, 말처럼 이동했으면 1을 늘림
            if nx < 0 or nx >= h or ny < 0 or ny >= w: # 허용 범위를 넘어가면
                continue
            if not d[nx][ny][nz] and not a[nx][ny]: #장애물이 없으면 and ????
                d[nx][ny][nz] = d[x][y][z]+1#움직인 횟수에 1을 추가 
                q.append((nx, ny, nz)) # 그리고 이걸 시작 파트로 만들기 위해 큐에 넣음
    print(-1)

bfs()
