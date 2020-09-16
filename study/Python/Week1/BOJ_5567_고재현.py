import sys
from collections import deque

def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = True
    level = 0
    friends = 0

    while q:
        level += 1
        
        for _ in range(len(q)): #level에 따라 나눠서 계산하기 때문에 필요함
            v = q.popleft()
            for i in adj[v]:
                if not(visited[i]):
                    visited[i] = True
                    q.append(i)
                    friends += 1
        if level == 2:
            break


    return friends

n = int(input())
m = int(input())
adj = [[] for _ in range(n+1)]
visited = [False]*(n+1)

for _ in range(m):
    a, b = map(int,input().split())
    adj[a].append(b)
    adj[b].append(a) #연결된 걸 나타내기 위해

print(bfs(1))
