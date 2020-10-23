from collections import deque
import sys
read = sys.stdin.readline

def bfs(x):
    q = deque()
    q.append(x)
    visit[x] = 1
    cnt = 0
    while q:
        k = q.popleft()
        for nx in way[k]:
            if visit[nx] == 0:
                visit[nx] = 1
                cnt += 1
                q.append(nx)
    return cnt

for _ in range(int(read())):
    n, m = map(int, read().split())
    way = [[] for _ in range(n)]
    visit = [0 for _ in range(n)]
    for i in range(m):
        a, b = map(int, read().split())
        way[a-1].append(b-1)
        way[b-1].append(a-1)
    ans = 0
    for i in range(n):
        if visit[i] == 0:
            ans += bfs(i)
    print(ans)

