#2251 물통
from collections import deque
import sys
input = sys.stdin.readline
def bfs():
    while q:
        # x ,y ,z 는 들어있는 물의 용량
        x, y, z = q.popleft()
        if check[x][y] == 1:
            continue
        check[x][y] = 1
        if x == 0:
            ans[z] = 1
            
        if x + y > b: # a -> b 
            q.append([x + y - b, b, z]) # x - (b-y) 로 생각
        else:
            q.append([0, x + y, z]) 
            
        if x + z > c: # a -> c
            q.append([x + z - c, y, c])
        else:
            q.append([0, y, x + z])
            
        if y + x > a: # b -> a
            q.append([a, y + x - a, z])
        else:
            q.append([y + x, 0, z])
            
        if y + z > c: # b -> c
            q.append([x, y + z - c, c])
        else:
            q.append([x, 0, y + z])
            
        if z + x > a: # c -> a
            q.append([a, y, z + x - a])
        else:
            q.append([z + x, y, 0])
            
        if z + y > b: # c -> b
            q.append([x, b, z + y - b])
        else:
            q.append([x, z + y, 0])
            
a, b, c = map(int, input().split()) # 물통의 용량
check = [[0] * 201 for i in range(201)]
ans = [0 for i in range(201)]
q = deque()
q.append([0, 0, c])
bfs()
for i in range(201):
    if ans[i]: print(i, end=" ")
