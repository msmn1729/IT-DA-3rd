room = [[0]*n for _ in range(m)] 
visited =[]
dx = [1,-1,0,0]
dy = [0,0,1,-1]

def dfs(i,j):
    cnt = 0
    for nx,ny in dx,dy:
        x = i+nx
        y = j +ny
        if x < 1 or y < 1 or x > n or y > m:
            continue
        if room[x][y] != 0:
            
    return room

