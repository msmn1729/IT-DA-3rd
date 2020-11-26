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
        tt.append(q[i])
        continue
    if tt[0][1] > q[i][0]:
        tt.append(q[i])
    else:
        tt.pop(0)
        tt.append(q[i])
print(len(tt))
