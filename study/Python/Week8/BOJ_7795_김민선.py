import sys

T = int(sys.stdin.readline())
res = [0 for i in range(T)]
for i in range(T):
    N,M = map(int,sys.stdin.readline().split())
    A = list(map(int,sys.stdin.readline().split()))
    B = list(map(int,sys.stdin.readline().split()))
    A.sort(); B.sort()
    for j in range(len(A)):
        k = 0
        while k<len(B) and A[j]>B[k]:
            k += 1
        res[i] += k
    print(res[i])