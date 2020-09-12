# n m k 입력
n, m, k = map(int, input().split())

# 쓰레기 위치 입력
pos = []
for i in range(k):
    r, c = map(int, input().split())
    pos.append((r,c))
    print(pos)

# 지도에 쓰레기 위치 1로 입력
arr = []
for i in range(n):
    for j in range(m):
        if (i,j) in pos:
            arr[i][j] = 1
        arr[i][j] = 0

# BFS로 쓰레기가 옆에 있는지 확인
queue = [(0, 0)]
for i in range(n):
    for j in range(m):
        if a[i][j] == 1:
            queue.append()


# 쓰레기 크기 출력
print(len())