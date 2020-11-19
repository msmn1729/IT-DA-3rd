import sys
d, n = map(int, input().split())
x = list(map(int, input().split()))
y = list(map(int, input().split()))

def func(a,x,depth):
    for j in range(depth):
        if x[j] < a:
            return j
    if x[depth-1] >= a:
        return depth-1
    return 0

if __name__ == "__main__":
    depth = d

    for i in range(n):
        depth = func(y[i], x, depth-1)
    print(depth+1)
