n , m = map(int,input().split())
a = list(map(int,input().split()))
time_l = 1
time_h = 100000000
while(time_l + 1 < time_h ):
    time = (time_l + time_h) // 2
    cnt = 0
    for ia in a:
        cnt += time // ia
    if cnt >= m:
        time_h = time
    else:
        time_l = time
print(time_h)