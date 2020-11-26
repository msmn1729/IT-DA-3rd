import sys
read = sys.stdin.readline

for _ in range(int(read())):
    n, m = map(int, read().split())
    a = sorted(list(map(int, read().split())))
    b = sorted(list(map(int, read().split())))
    cnt = 0
    for i in a:
        if i > b[-1]:
            cnt += len(b)
            continue
        if i <= b[0]:
            continue
        left = 0
        right = len(b)-1
        while left+1 < right:
            mid = (left+right)//2
            if b[mid] >= i: right = mid
            else: left = mid
        cnt += left+1
    print(cnt)
