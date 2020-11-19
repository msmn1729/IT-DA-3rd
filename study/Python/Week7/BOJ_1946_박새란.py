t = int(input())

for _ in range(t):
    tx = []
    ty = []
    tsum = []
    n = int(input())
    cnt = 0
    x1, y1 =map(int, input().split())
    tx.append(x1)
    ty.append(y1)
    tsum.append(x1+y1)
    cnt+=1
    for _ in range(n-1):
        x, y =map(int, input().split())
        if tx[-1] > x and ty[-1] > y:
            del(tx[-1])
            del(ty[-1])
            del(tsum[-1])
            cnt-=1
        tx.append(x)
        ty.append(y)
        tsum.append(x+y)
        cnt+=1
    if tx[-1] > tx[-2] and tx[-1] > tx[-2]:
        del(tx[-1])
        del(ty[-1])
        del(tsum[-1])
        cnt-=1
    sum_min = tsum.index(min(tsum))
    
    
        
    print(cnt) 