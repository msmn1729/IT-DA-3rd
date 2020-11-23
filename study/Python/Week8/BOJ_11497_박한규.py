import sys
from _collections import deque
read = sys.stdin.readline

for _ in range(int(read())):
    n = int(read())
    l = sorted(list(map(int, read().split())))
    new_l = deque()
    for i in range(n):
        if i % 2 == 0:
            new_l.appendleft(l.pop(0))
        else:
            new_l.append(l.pop(0))
    level = 0
    for i in range(n):
        tmp = abs(new_l[i]-new_l[i-1])
        if tmp > level:
            level = tmp
    print(level)

