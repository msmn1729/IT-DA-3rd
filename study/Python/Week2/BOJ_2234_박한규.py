from collections import deque
import sys
input = sys.stdin.readline


def bfs(i, j, visit):
    q = deque()
    q.append([i, j])
    visit[i][j] = 1
    cnt = 1
    # 남, 서, 북, 동 -> 순서가 크게 중요하진 않음
    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]

    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < m and 0 <= ny < n and visit[nx][ny] == 0:
                if k == 0:      # 서
                    if 1 & s[x][y]: continue    # 비트연산을 통해 결과 값이 0이 나와야함
                elif k == 1:    # 북
                    if 2 & s[x][y]: continue    # 비트연산을 해서 0 이외의 값이 나오면
                elif k == 2:    # 동
                    if 4 & s[x][y]: continue    # 전부 True 처리되어 continue로 넘어감
                elif k == 3:    # 남
                    if 8 & s[x][y]: continue
                visit[nx][ny] = 1
                q.append([nx, ny])
                cnt += 1    # 방의 크기 한 칸씩 채워짐
    return cnt


def prog_12():
    visit_12 = [[0] * n for _ in range(m)]
    res_1 = 0; res_2 = 0
    for i in range(m):
        for j in range(n):
            if visit_12[i][j] == 0:
                res_1 += 1      # visit에서 0을 발견하는 경우는 새로운 방의 첫 부분을 찾았을 때 뿐
                res_2 = max(res_2, bfs(i, j, visit_12))     # bfs를 돌리며 visit에는 1이 계속 채워질 예정
    return res_1, res_2


def prog_3():
    res_3 = 0
    for i in range(m):
        for j in range(n):
            num = 1
            while num < 9:
                if num & s[i][j]:
                    visit_3 = [[0] * n for _ in range(m)]
                    s[i][j] -= num
                    res_3 = max(res_3, bfs(i, j, visit_3))
                    s[i][j] += num
                num *= 2
    return res_3


def main():
    global n, m, s
    n, m = map(int, input().split())
    s = [list(map(int, input().split())) for _ in range(m)]
    res_1, res_2 = prog_12()
    res_3 = prog_3()
    print(res_1); print(res_2); print(res_3)


main()


