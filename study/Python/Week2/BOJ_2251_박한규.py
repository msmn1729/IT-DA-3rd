import sys
from collections import deque
input = sys.stdin.readline

def bfs(a, b, c):
    start = (0, 0, c)
    res = set()
    queue = deque([start])
    visited = {start: 1}

    while queue:
        qa, qb, qc = queue.popleft()
        if qa == 0:
            res.add(qc)
        # c->
        if qc > 0:
            # a가 비어있을 때, c->a
            if qa < a:
                t = qa + qc
                # 들어올 물의 양이 a보다 작을 때
                if t <= a and not visited.get((t, qb, 0)):  # get은 dictionary의 value를 얻음
                    visited[(t, qb, 0)] = 1
                    queue.append((t, qb, 0))
                # 들어올 물의 양이 a보다 클 때
                elif t > a and not visited.get((a, qb, t - a)):
                    visited[(a, qb, t - a)] = 1
                    queue.append((a, qb, t - a))
            # b가 비어있을 때, c->b
            if qb < b:
                t = qb + qc
                if t <= b and not visited.get((qa, t, 0)):
                    visited[(qa, t, 0)] = 1
                    queue.append((qa, t, 0))
                elif t > b and not visited.get((qa, b, t - b)):
                    visited[(qa, b, t - b)] = 1
                    queue.append((qa, b, t - b))
        # a->
        if qa > 0:
            # a->b
            if qb < b:
                t = qa + qb
                if t <= b and not visited.get((0, t, qc)):
                    visited[(0, t, qc)] = 1
                    queue.append((0, t, qc))
                elif t > b and not visited.get((t - b, b, qc)):
                    visited[(t - b, b, qc)] = 1
                    queue.append((t - b, b, qc))
            # a->c
            if qc < c:
                t = qa + qc
                if t <= c and not visited.get((0, qb, t)):
                    visited[(0, qb, t)] = 1
                    queue.append((0, qb, t))
                elif t > c and not visited.get((t - c, qb, c)):
                    visited[(t - c, qb, c)] = 1
                    queue.append((t - b, qb, c))
        # b->
        if qb > 0:
            # b->a
            if qa < a:
                t = qa + qb
                if t <= a and not visited.get((t, 0, qc)):
                    visited[(t, 0, qc)] = 1
                    queue.append((t, 0, qc))
                elif t > a and not visited.get((a, t - a, qc)):
                    visited[(a, t - a, qc)] = 1
                    queue.append((a, t - a, qc))
            # b->c
            if qc < c:
                t = qb + qc
                if t <= c and not visited.get((qa, 0, t)):
                    visited[(qa, 0, t)] = 1
                    queue.append((qa, 0, t))
                elif t > c and not visited.get((qa, t - c, c)):
                    visited[(qa, t - c, c)] = 1
                    queue.append((qa, t - c, c))

    return res


def main():
    a, b, c = map(int, input().split())
    res = sorted(bfs(a, b, c))
    for i in res:
        print("{} ".format(i), end='')


main()

