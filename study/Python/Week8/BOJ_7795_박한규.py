import sys
read = sys.stdin.readline

for _ in range(int(read())):
    n, m = map(int, read().split())
    a = list(map(int, read().split()))
    b = sorted(list(map(int, read().split())))
    cnt = 0     # a > b 갯수 일일이 카운트 해줄 거임
    for i in a:
        if i > b[-1]:       # a 요소가 b중 가장 큰놈보다 클 경우는 빠르게 처리
            cnt += len(b)
            continue
        if i <= b[0]:       # a 요소가 b중 가장 작은놈보다 작거나 같으면 어차피 없으니 넘기기
            continue
        left = 0
        right = len(b)-1
        while left+1 < right:
            mid = (left+right)//2
            if b[mid] >= i: right = mid
            else: left = mid
        cnt += left+1       # list index는 하나 더 작으니까 +1 처리
    print(cnt)
