#성곽
comment = '''
풀이과정:
처음에는 1번, 2번 문제를 dfs로 접근 하였음. 방향벡터를 잘못 적어서 디버깅하느라 애썼다.
남쪽으로 가는거를 수학에서의 좌표평면을 생각해버려서 (x,y) = (0,1)이 아닌 (0,-1)로 생각하느라 시간 버림 ㅎ
이후 여차저차 디버깅하였으나 3번문제에서 dfs로 풀 수 없음을 깨달음
저번에 풀었던 벽뚫기 문제는 반드시 bfs로만 풀 수 있었기 때문
그래서 bfs로 바꾸었고 벽을 만났으면 dfs로 새로운 탐색을 하려고 했으나
dfs는 특성상 리턴값을 반환하기 힘들어서 그 공간에 다시 bfs를 돌리는 것으로 해결함
근데 생각해보니 처음에 dfs돌리고 벽 뚫었을때 bfs돌리면 됐었네? ㅎㅎ 시간버렸다..

핵심 아이디어:
1번 문제의 답은 2중 for문을 돌 때 bfs함수의 실행 횟수를 세면 된다.
2번 문제의 답은 영역의 넓이를 구하면서 최대값을 갱신해주면 된다.
3번 문제를 풀기 위해서 우선 bfs, 또는 dfs로 탐색을 하면서 영역을 칠한다.
칠한것은 visited[][][0]에 표시한다.
이후 벽을 만나면 반드시 bfs2로 탐색하며 탐색한 영역의 넓이를 알아낸다.
bfs2는 visited[][][1]에 표시한다.
bfs2로 탐색시 기존의 영역과 만나게 되면 한개의 영역이므로 영역의 넓이는 0을 리턴해 준다.
결과적으로 뚫을수 있는 벽은 1개만 뚫리게 되며 이미 뚫어서 방문한 영역은 다시 계산할 필요 없으므로
visited[][][1]은 초기화시키지 말아야 한다.
그러면 3번 문제의 답은 기존의 영역의 넓이 + 뚫은 영역의 최대값이 된다.
이중 for문을 통해 맵의 모든 곳을 탐색하면서 최대값을 갱신해주면 된다.
'''

from collections import deque
N, M = 0,0
Map = []
visited = []
numofRoom = 0
maxRoomArea = 0
maxRoomArea2 = 0

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

def bfs2(_y, _x):
    global N, M, visited, Map
    
    roomArea = 0
    
    q = deque([[_y, _x]])
    visited[_y][_x][1] = True
    
    while q:
        y, x = q.popleft()
        wall = isWall(Map[y][x])
        roomArea += 1
        
        if visited[y][x][0]:
            return 0
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny == M or nx == N:
                continue
            if not visited[ny][nx][1] and not wall[i]:
                visited[ny][nx][1] = True
                q.append([ny, nx])
                
    return roomArea
    
    
def bfs(_y, _x):
    global N, M, visited, Map
    
    roomArea = 0
    roomArea2 = 0
    
    q = deque([[_y, _x]])
    visited[_y][_x][0] = True
    
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
                if not visited[ny][nx][1]:
                    roomArea2 = max(bfs2(ny,nx),roomArea2)
            else:
                if not visited[ny][nx][0]:
                    visited[ny][nx][0] = True
                    q.append([ny,nx])
    
    return roomArea, roomArea2            

if __name__ == "__main__":
    N, M = map(int,input().split())
    for _ in range(M):
        Map.append(list(map(int,input().split())))
    visited = [[[False, False] for _ in range(N)] for _ in range(M)]
    
    for y in range(M):
        for x in range(N):
            if not visited[y][x][0]:
                roomArea, roomArea2 = bfs(y,x)
                maxRoomArea = max(maxRoomArea, roomArea)
                maxRoomArea2 = max(maxRoomArea2, roomArea + roomArea2)
                numofRoom += 1
    
    print(numofRoom)
    print(maxRoomArea)
    print(maxRoomArea2)
                
    
    