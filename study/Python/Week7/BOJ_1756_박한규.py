import sys
read = sys.stdin.readline

d, n = map(int, read().split())
oven = list(map(int, read().split()))
dough = list(map(int, read().split()))


new_oven = [oven[0]]
for i in range(d-1):
    if oven[i+1] >= oven[i]:
        new_oven.append(new_oven[i])
    else:
        new_oven.append(oven[i+1])
new_oven.append(0)                     # 바닥으로 들어갈 친구를 위해
print(new_oven)

loc = []
low = d
flag = True
for k in dough:
    if k > new_oven[0] or low == 0:     # 입구컷 or 이미 꽉 참
        flag = False
        break
    high = 0
    while high+1 < low:
        mid = (high + low)//2
        if new_oven[mid] >= k: high = mid
        else: low = mid
    low = high
    loc.append(low)

if flag:
    print(loc[-1]+1)
else:
    print(0)
