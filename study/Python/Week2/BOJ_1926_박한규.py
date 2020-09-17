from collections import deque
import sys
input = sys.stdin.readline

def bfs(i, j, visit):
    q = deque()
    q.append([i, j])
    visit[i][j] = 1
    cnt = 1
    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]

    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < m and 0 <= ny < n and visit[ny][nx] == 0 and s[ny][nx] == 1:
                visit[ny][nx] = 1
                q.append([nx, ny])
                cnt += 1
    return cnt


def prog():
    visit = [[0] * m for _ in range(n)]
    paint_cnt = 0; paint_max = 0
    for i in range(n):
        for j in range(m):
            if visit[i][j] == 0 and s[i][j] == 1:
                paint_cnt += 1
                paint_max = max(paint_max, bfs(i, j, visit))
    return paint_cnt, paint_max


def main():
    global n, m, s
    n, m = map(int, input().split())
    s = [list(map(int, input().split())) for _ in range(n)]
    paint_cnt, paint_max = prog()
    print(paint_cnt)
    print(paint_max)

main()



