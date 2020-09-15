from sys import stdin
from collections import deque
input = stdin.readline

# 이동방향 0~3:인접한/ 4~12:체스의 나이트
dx = (-1, 0, 1, 0, 2, 1, -1, -2, -2, -1, 1, 2)
dy = (0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1)

k = int(input())
w, h = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(h)]

d = [[[0]*(k+1) for _ in range(w)] for _ in range(h)]  # [x][y][말점프 횟수]


def bfs():
    q = deque()
    q.append((0, 0, 0))  # x,y좌표. 말점프횟수
    while q:
        x, y, z = q.popleft()
        j = 4 if z == k else 12  # 능력을 모두 사용했을 때 for문의 범위 줄이기 => 인접한 방향으로 이동
        if x == h-1 and y == w-1:  # 목적지 도착
            print(d[x][y][z])
            return
        for i in range(j):
            nx, ny = x+dx[i], y+dy[i]
            nz = z if i < 4 else z+1 #능력 사용
            if nx < 0 or nx >= h or ny < 0 or ny >= w: #존재하지 않는 위치
                continue
            if not d[nx][ny][nz] and not a[nx][ny]: #새로운위치.장애물x
                d[nx][ny][nz] = d[x][y][z] + 1
                q.append((nx, ny, nx)) #새로운 위치 queue에 넣기
    print(-1)


bfs()
#https://rebas.kr/741
