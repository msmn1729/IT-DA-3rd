#미친로봇 DFS_BFS

import sys

direction=[0,0,0,0]

num, direction[0],direction[1],direction[2],direction[3]=map(int,sys.stdin.readline().split())

visit=[[False for _ in range(30)] for _ in range(30)]
direction=[i/100 for i in direction]

dx=[1,-1,0,0]
dy=[0,0,-1,1]

result=0

def dfs(x,y,pob,count):
    global result

    if count==num:
        result +=pob
        return
    
    for i in range(4):
        nx,ny=x+dx[i], y+dy[i]
        if not visit[nx][ny]:
            visit[nx][ny]==True
            dfs(nx,ny,pob*direction[i],count+1)
            visit[nx][ny]==False
    return 0
            

visit[15][15]=True
dfs(15,15,1,0)


print(result)

