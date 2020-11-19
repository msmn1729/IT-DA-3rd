import sys
read = sys.stdin.readline

n, m = map(int, read().split())
a = list(map(int, read().split()))

left = min(a)
right = min(a)*m

while left+1 < right:           # 이 아이디어... 어렵다
    mid = (left + right) // 2
    cnt = 0
    for i in a:
        cnt += mid // i
    if cnt >= m: right = mid
    else: left = mid
print(right)






# 처음엔 List를 구현해서 풀어주어야 한다고 생각했음..
# 그냥 사칙연산으로 하면 됨 ㅎㅎ..

# while True:
#     cnt = 0
#     for i in a:
#         cnt += bs[mid_idx]//i
#     if cnt == m:
#         print(bs[mid_idx])
#         break
#     elif cnt < m:
#         left = mid_idx
#     else:
#         right = mid_idx
#     mid_idx = (left + right) // 2

