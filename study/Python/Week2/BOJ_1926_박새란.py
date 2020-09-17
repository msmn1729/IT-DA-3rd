from collections import deque

visited = []
dx = [0,0,1,-1]
dy = [1,-1,0,0]
def bfs(i,j):
    q = deque()
    q.append([i,j])
    while q:
        result1 = 0
        n = q.popleft()
        for k in range(4):
            x = n[0] + dx[k]
            y = n[1] + dy[k]
            if 0 <= x <n and 0<= y < m: #그림범위
                if (draw[x][y] == 1): 
                    if ([x,y] not in visited):
                        visited.append([x,y])
                        q.append([x,y])
                    if sol(x,y) :#그림이 끝나려면 
                        
                    
    return visited
result = []
def sol(visited):
    draw_num = 0
    if :
        draw_num +=1

        

n,m = map(int,input().split())
draw = [[0]*m for _ in range(n)]

