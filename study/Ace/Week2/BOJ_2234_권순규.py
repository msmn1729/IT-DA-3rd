from collections import deque
N, M = 0,0
Map = []
visited = []
visited2 = [] # 벽 뚫고 영역 방문할 때 사용
numofRoom = 0
maxRoomArea = 0
maxRoomArea2 = 0
dataHash = {}

# 남동북서
dx, dy = [0,1,0,-1],[1,0,-1,0]

def isWall(n):
    # 남동북서
    lst = [False, False, False, False]
    num = [8,4,2,1]
    for i in range(4):
        if n & num[i]:
            lst[i] = True
    
    return lst

def bfs2(_y, _x, nr):
    global N, M, visited2, Map
    
    roomArea = 0
    
    q = deque([[_y, _x]])
    visited2[_y][_x] = True
    
    while q:
        y, x = q.popleft()
        wall = isWall(Map[y][x])
        roomArea += 1
        
        if visited[y][x][1]==nr:
            erase(y,x)
            return 0
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny == M or nx == N:
                continue
            if not visited2[ny][nx] and not wall[i]:
                visited2[ny][nx] = True
                q.append([ny, nx])
    
    return roomArea

def erase(_y, _x):
    global Map, visited2
    
    tmp = [[False for _ in range(N)] for _ in range(M)]
    q = deque([[_y, _x]])
    tmp[_y][_x] = True
    
    while q:
        y, x = q.popleft()
        visited2[y][x] = False
        wall = isWall(Map[y][x])
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny == M or nx == N:
                continue
            if not tmp[ny][nx] and not wall[i]:
                tmp[ny][nx] = True
                q.append([ny, nx])
    
def bfs(_y, _x):
    global N, M, visited, visited2, Map, dataHash, numofRoom
    visited2 = [[False for _ in range(N)] for _ in range(M)]
    roomArea = 0
    roomArea2 = 0
    
    q = deque([[_y, _x]])
    visited[_y][_x][0] = True
    visited[_y][_x][1] = numofRoom
    
    while q:
        y, x = q.popleft()
        wall = isWall(Map[y][x])
        roomArea += 1
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny == M or nx == N:
                continue
            if wall[i]:
                if not visited2[ny][nx]:
                    if visited[ny][nx][0]:
                        if visited[ny][nx][1] != numofRoom: #0자 모양 방지하기 위함
                            roomArea2 = max(roomArea2,dataHash[visited[ny][nx][1]])
                    else:
                        roomArea2 = max(bfs2(ny,nx,numofRoom),roomArea2)
                
            else:
                if not visited[ny][nx][0]:
                    visited[ny][nx][0] = True
                    visited[ny][nx][1] = numofRoom
                    q.append([ny,nx])
    
    dataHash[numofRoom]=roomArea
    return roomArea, roomArea2            

if __name__ == "__main__":
    N, M = map(int,input().split())
    for _ in range(M):
        Map.append(list(map(int,input().split())))
    visited = [[[False, -1] for _ in range(N)] for _ in range(M)]
    visited2 = [[False for _ in range(N)] for _ in range(M)]
    
    for y in range(M):
        for x in range(N):
            if not visited[y][x][0]:
                numofRoom += 1
                roomArea, roomArea2 = bfs(y,x)
                maxRoomArea = max(maxRoomArea, roomArea)
                maxRoomArea2 = max(maxRoomArea2, roomArea + roomArea2)
    
    print(numofRoom)
    print(maxRoomArea)
    print(maxRoomArea2)