from collections import deque
import sys

input = sys.stdin.readline

monkey_x = [1, -1, 0, 0]
monkey_y = [0, 0, 1, -1]
horse_x = [1, 1, -1, -1, 2, 2, -2, -2]
horse_y = [2, -2, 2, -2, 1, -1, 1, -1]

def bfs():
    queue.append([0, 0, 0])      # deque([[0, 0, 0]])
    arr[0][0][0] = 1               # 맨 처음 원숭이가 있는 곳
    while queue:
        x, y, a = queue.popleft()
        if x == h-1 and y == w-1:   # 목적지에 도달 하면
            print(arr[x][y][a]-1)   # 횟수 출력
            return
        if a < k:                   # 능력을 아직 다 사용하지 않았으면
            horse(x, y, a)
            monkey(x, y, a)
        elif a == k:                # 능력을 다 사용하였으면
            monkey(x, y, a)
        print(arr)

    print(-1)

def horse(x, y, a):                 # 단순하게 horse의 a가 monkey의 a보다 1 크다고 생각하면 될 듯
    for i in range(len(horse_x)):
        nx = x + horse_x[i]
        ny = y + horse_y[i]
        if 0 <= nx < h and 0 <= ny < w:
            if map[nx][ny] == 0 and arr[nx][ny][a+1] == 0:  # 장애물이 없고, 간 적도 없으면
                arr[nx][ny][a+1] = arr[x][y][a] + 1
                queue.append([nx, ny, a+1])

def monkey(x, y, a):
    for i in range(len(monkey_x)):
        nx = x + monkey_x[i]
        ny = y + monkey_y[i]
        if 0 <= nx < h and 0 <= ny < w:
            if map[nx][ny] == 0 and arr[nx][ny][a] == 0:
                arr[nx][ny][a] = arr[x][y][a] + 1
                queue.append([nx, ny, a])

k = int(input())
w, h = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(h)] # 지도 저장, _는 특정 값 무시
arr = [[[0]*(k+1) for _ in range(w)] for _ in range(h)]   #
print(arr)
queue = deque()

bfs()