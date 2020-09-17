from collections import deque
Map = []
N,M,D = 0,0,0
answer = 0
dx,dy = [1,-1,0,0],[0,0,-1,1]

def attack():
    global answer
    for i in range(M):
        for j in range(i+1,M):
            for k in range(j+1,M):
                position = [i,j,k]
                answer = max(answer,cal(position))
    

def cal(position):
    global Map
    enemy = []
    for i in position:
        enemy.append(bfs(i))
    
    return len(set(enemy))

def bfs(i):
    global Map
    enemy = []
    visited = [[False for _ in range(M)] for _ in range(N)]
    q = deque([[N-1,i,1]])
    visited[N-1][i] = True
    while q:
        y,x,d = q.popleft()
        
        if Map[y][x] == 1:
            enemy.append([N-1,i])
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny == N or nx == M:
                continue
            
            if not visited[ny][nx] and d < D:
                visited[ny][nx] = True
                enemy.append([ny,nx])
    
    return enemy
        
        
            

def EnemyDown():
    global Map
    for i in range(N-1,0,-1):
        Map[i] = Map[i-1]
    Map[0] = [0 for _ in range(M)]        

def func():
    attack()
    EnemyDown()

if __name__== "__main__":
    N, M, D = map(int,input().split())

    for _ in range(N):
        Map.append(map(int,input().split()))
        
    for _ in range(N):
        func()
    