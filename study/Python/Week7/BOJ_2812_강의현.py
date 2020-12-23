# 크게 만들기 - G5

import sys
sys.setrecursionlimit(10**9)

N, K=map(int,sys.stdin.readline().split())

num=list(sys.stdin.readline().strip())

stack=list()

for i in range(N):
    now=num[i]

    while stack and stack[-1]<now and K>0:
        stack.pop()
        K-=1

    stack.append(now)

# 출력문 직관적이게 변경
for i in range(len(stack)-K):
    print(stack[i],end='')