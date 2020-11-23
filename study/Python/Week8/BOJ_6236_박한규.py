import sys
read = sys.stdin.readline

n, m = map(int, read().split())
l = []
for _ in range(n):
    l.append(int(read()))
min, max = max(l), sum(l)
while min+1 < max:
    cnt = 0
    sum = 0
    mid = (min+max)//2
    for i in l:
        sum += i
        if sum > mid:
            sum = i
            cnt += 1
    if sum > 0:
        cnt += 1
    if cnt >= m: min = mid
    else: max = mid
print(min)