from collections import deque
import sys

def bfs(x0,y0):
    q = deque(); res = []
    q.append([x0,y0]); res.append([x0,y0])
    while q:
        x, y = q.popleft(); beer = 20
        if x==festival_x and y==festival_y :
            return "happy"
        for dx, dy in d:
            if [dx, dy] not in res:
                if beer*50>= abs(dx-x)+abs(dy-y):
                    q.append([dx,dy])
                    res.append([dx,dy])
    return "sad"

T = int(sys.stdin.readline())

for i in range(T):
    n = int(sys.stdin.readline())
    house_x,house_y = map(int,sys.stdin.readline().split())
    d = []
    for j in range(n):
        x,y = map(int,sys.stdin.readline().split())
        d.append([x,y])
    festival_x,festival_y = map(int,sys.stdin.readline().split())
    d.append([festival_x,festival_y])
    print(bfs(house_x,house_y))