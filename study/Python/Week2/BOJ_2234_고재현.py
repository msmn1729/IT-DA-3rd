#2234 성곽
#참고 : https://pacific-ocean.tistory.com/401
# result3 나오는 방법은 이해 못함

from collections import deque
import sys
input = sys.stdin.readline
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
def bfs(i, j):
    q = deque()
    q.append([i, j])
    visit[i][j] = 1
    cnt = 1 #cnt는 방의 크기를 저장하는 변수
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < m and 0 <= ny < n and visit[nx][ny] == 0:
                if k == 0: #왼쪽으로 갈 때
                    if 1 & s[x][y]: continue #서쪽 벽이 막혀있으면 continue
                elif k == 1:
                    if 2 & s[x][y]: continue
                elif k == 2:
                    if 4 & s[x][y]: continue
                elif k == 3:
                    if 8 & s[x][y]: continue
                visit[nx][ny] = 1 #벽이 없어서 움직였으면 visit 체크하고
                q.append([nx, ny]) # 시작점으로 만들기 위해 append
                cnt += 1
    return cnt
n, m = map(int, input().split())
s = [list(map(int, input().split())) for i in range(m)]
visit = [[0] * n for i in range(m)]
result1, result2, result3 = 0, 0, 0
for i in range(m):
    for j in range(n):
        if visit[i][j] == 0:
            result1 += 1 # 같은 방에 속한 좌표들은 bfs 함수에서 처리했으므로 바로 +1 해줌
            result2 = max(result2, bfs(i, j))


"""
 if 1 & s[x][y] 이 부분은 비트연산을 하는 것인데, 벽에 대한 정보가 2진수로 나타났으므로
 0001, 0010, 0100, 1000 을 이용해 계산.
 
"""
 
