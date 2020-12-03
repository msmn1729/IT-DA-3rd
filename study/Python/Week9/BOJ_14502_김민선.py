#시간초과

import sys
max_result = 0

def bfs():
    virus = []; arr = [[0] * m for i in range(n)]; res = 0
    for i in range(n):
        for j in range(m):
            arr[i][j] = lab[i][j]
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 2:
                virus.append([i,j])
    while virus:
        x = virus[0][0]; y = virus[0][1]
        del virus[0]
        for i in range(4):
            if 0 <= x+dx[i] < n and 0 <= y+dy[i] < m:
                if arr[x+dx[i]][y+dy[i]] == 0:
                    arr[x+dx[i]][y+dy[i]] = 2
                    virus.append([x+dx[i],y+dy[i]])
    for i in arr:
        for j in i:
            if j==0 :
                res += 1
    global max_result
    max_result = max(max_result,res)

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                lab[i][j] = 1
                wall(cnt+1)
                lab[i][j] = 0

n,m = map(int,sys.stdin.readline().split())
lab = []
dx = [0, 0, -1, 1] #방향 설정
dy = [-1, 1, 0, 0]
for i in range(n):
    lab.append(list(map(int,sys.stdin.readline().split())))

wall(0)
print(max_result)

#https://pacific-ocean.tistory.com/262 참고