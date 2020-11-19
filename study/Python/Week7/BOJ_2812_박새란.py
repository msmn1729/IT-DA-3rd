n, k  = map(int, input().split())
x = list(input())
dq = []
dq_k = k

for i in range(n):
    while(dq_k > 0 and dq):
        if(dq[-1] < x[i]):
            del dq[-1]
            dq_k-=1
    dq.append(x[i])

print(''.join(dq[:n-k]))


