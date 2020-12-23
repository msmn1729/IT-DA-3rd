import heapq
import sys
read = sys.stdin.readline

n = int(read())
q = []
tt = []
cnt = 0
for _ in range(n):
    q.append(list(map(int, read().split())))
q.sort(key=lambda x: x[1])

for i in range(n):
    if not tt:
        heapq.heappush(tt, q[i])
        continue
    if tt[0][1] > q[i][0]:
        heapq.heappush(tt, q[i])
    else:
        heapq.heappop(tt)
        heapq.heappush(tt, q[i])
print(len(tt))
