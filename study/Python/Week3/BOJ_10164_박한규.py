import sys
read = sys.stdin.readline


def fact(n):
    if n == 1:
        return 1
    else:
        return n * fact(n-1)

def oper(startX, startY, desX, desY):
    x = desX - startX - 1
    y = desY - startY - 1
    sum = x + y
    return fact(sum) // fact(x) // fact(y)


n, m, k = map(int, read().split())
if k == 0:
    print(oper(0, 0, m, n))
else:
    mid_posX = k%m
    mid_posY = (k//m)+1
    res1 = oper(0, 0, mid_posX, mid_posY)
    res2 = oper(mid_posX, mid_posY, m+1, n+1)
    print(res1*res2)


