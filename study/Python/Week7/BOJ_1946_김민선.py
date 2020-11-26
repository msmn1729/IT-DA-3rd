def count(first, second):
    cnt = N; tmp_a = N; tmp_b = N
    for i in range(N):
        if tmp_a <= first[i] or tmp_b <= second[i] :
            tmp_a = first[i]; tmp_b = second[i]
            cnt -= 1
    arr.append(cnt)

T = int(input())
arr = []
for i in range(T):
    N = int(input())
    a = [0 for i in range(N)]
    b = [0 for i in range(N)]
    for j in range(N):
        a[j], b[j] = map(int,input().split())
    count(a,b)

for i in range(T):
    print(arr[i])