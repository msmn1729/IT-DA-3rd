#서로 연결시키는 점이면 단절점 : 점 하나에 한 개 이상의 점들이 연결되어 있으면
#단절선은 모두 yes
import sys

N = int(sys.stdin.readline())
dots = [[] for i in range(N+1)]
for i in range(N-1):
    a,b = map(int,sys.stdin.readline().split())
    dots[a].append(b)
    dots[b].append(a)

q = int(sys.stdin.readline())
for i in range(q):
    t,k = map(int,sys.stdin.readline().split())
    if t == 1:
        if len(dots[k]) <= 1:
            print('no')
        else:
            print('yes')
    else:
        print('yes')