from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    queue = deque()
    visit[start] = 1
    queue.append(start)
    
    while queue:
        node = queue.popleft()
        for i in range(1,n+1):
            if visit[i] == 0 and s[node][i] == 1:
                queue.append(i)
                visit[i] = visit[node] + 1
            
n = int(input())
m = int(input())
    
s = [[0]*(n+1) for _ in range(n+1)] #간선 정보 저장 리스트
visit = [0 for _ in range(n+1)] #시작 정점으로부터의 거리 정보를 담을 리스트

# 간선의 정보를 입력받으면서 양방향 그래프 생성
for _ in range(m):
    a,b =  map(int, input().split())
    s[a][b] = 1
    s[b][a] = 1
#v[a][b] = 1
#v[b][a] = 1
bfs(1)
friend = 0

#거리가 3이하인 정점만 개수에 더해줌(친구, 친구의친구)
for i in range(2,n+1):
    if visit[i] == 2 or visit[i] == 3:
        friend += 1
        
print(friend)
