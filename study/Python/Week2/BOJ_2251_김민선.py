from collections import deque

def bfs():
    q = deque()
    q.append([0,0,C])
    while q:
        la,lb,lc=q.popleft()
        if check[la][lb] == 1: continue
        check[la][lb] = 1
        
        #A가 0L면 C의 현재 리터수 기록
        if la == 0: case[lc]=1
        #a->b
        if la+lb > B: q.append([la+lb-B, B, lc])
        else: q.append([0, la+lb, lc])
        #a->c
        if la+lc > C: q.append([la+lc-C, lb, C])
        else: q.append([0, lb, la+lc])
        #b->a
        if lb+la > A: q.append([A, lb+la-A, lc])
        else: q.append([lb+la, 0, lc])
        #b->c
        if lb+lc > C: q.append([la, lb+lc-C, C])
        else: q.append([la, 0, lb+lc])
        #c->a
        if lc+la > A: q.append([A, lb, lc+la-A])
        else: q.append([lc+la, lb, 0])
        #c->b
        if lc+lb > B: q.append([la, B, lc+lb-B])
        else: q.append([la, lc+lb, 0])

A,B,C = map(int, input().split())
#a,b의 값으로 인덱스 -> 한 과정 한 과정 독립적으로 보여주게 하기 위함
check = [[0]*201 for i in range(201)]
case = [0 for i in range(201)]
bfs()
for i in range(201):
    if case[i] : print(i,end=" ")