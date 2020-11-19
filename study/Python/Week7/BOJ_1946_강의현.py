# 신입사원 - S1

import sys

T=int(sys.stdin.readline())

for _ in range(T):
    N=int(sys.stdin.readline())
    employee=list()
    for _ in range(N):
        t1,t2=map(int,sys.stdin.readline().split())

        employee.append((t1,t2))

    employee.sort()

    standard=employee[0][1]
    count=N
    for i in range(1,N):
        if employee[i][1]>standard:
            count-=1
        else:
            standard=employee[i][1]

    print(count)
