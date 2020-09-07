from collections import deque

dx, dy = [1,0, -1, 0], [0, 1, 0, -1]
ndx, ndy = [-2,-2,-1,-1,2,2,1,1 ], [1,-1,2,-2,1,-1,2,-2]

K = int(input())
W, H = map(int,input().split())
Map = []
visited1 = [[False for _ in range(W)] for _ in range(H)]
visited2 = [[False for _ in range(W)] for _ in range(H)]
destination = [H-1, W-1]
for i in range(H):
    tmp = list(map(int,input().split()))
    Map.append(tmp)

def bfs():
    answer = -1
    q = deque([[0, 0, 0, 0]])
    visited1[0][0] = True
    visited2[0][0] = True
    while q:
        y, x, n, d = q.popleft()
        if [y, x] == destination:
            answer = d
            break
        
        if n < K:
            for i in range(8):
                ny = y + ndy[i]
                nx = x + ndx[i]
                if nx < 0 or ny < 0 or nx >= W or ny >= H or Map[ny][nx] == 1 or visited1[ny][nx]:
                    continue
                visited1[ny][nx] = True
                q.append([ny, nx, n+1, d+1])
                
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if nx < 0 or ny < 0 or nx >= W or ny >= H or Map[ny][nx] == 1 or visited2[ny][nx]:
                    continue
                visited2[ny][nx] = True
                q.append([ny, nx, n, d+1])

        else:
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if nx < 0 or ny < 0 or nx >= W or ny >= H or Map[ny][nx] == 1 or visited1[ny][nx]:
                    continue
                visited1[ny][nx] = True
                q.append([ny, nx, n, d+1])
    
    return answer

print(bfs())