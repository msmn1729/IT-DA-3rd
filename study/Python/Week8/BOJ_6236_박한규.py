# 아니 왜 안되는거야 ㅡ
import sys
read = sys.stdin.readline

def pay(k):
    cash = 0
    cnt = 0
    for i in l:
        if k < i:
            return -1
        if cash < i:
            cnt += 1
            cash = k
            if cnt > m: return 0
        cash -= i
    if cnt==m: return 1
    else: return 2

n, m = map(int, read().split())
l = []
for _ in range(n):
    l.append(int(read()))
lo, hi = max(l), sum(l)

while lo < hi:
    mid = (lo + hi)//2
    res = pay(mid)
    if res == -1 or res == 0:
        lo = mid+1
    if res == 1 or res == 2:
        hi = mid+1
print(lo)



