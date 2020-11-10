import sys
read = sys.stdin.readline

n = int(read())
tree = [[] for _ in range(n)]
for _ in range(n-1):
    a, b = map(int, read().split())
    tree[a-1].append(b-1)
    tree[b-1].append(a-1)

for _ in range(int(read())):
    t, k = map(int, read().split())
    if t == 1:
        if len(tree[k-1]) <= 1:
            print('no')
        else:
            print('yes')
    elif t == 2:
        print('yes')

# 1차 시도: 2차원 배열로 시도하려 했으나 n의 값이 100000이라 너무 커서 실패...

# def vertex(k):
#     cnt = 0
#     for i in range(n):
#         if edge[i][k-1] == 1:
#             cnt += 1
#     if cnt == 1:
#         print('no')
#     else:
#         print('yes')
#
# def bridge(k):
#     a = order[k-1][0]
#     b = order[k-1][1]
#     edge[a][b] = 0
#     edge[b][a] = 0
#     cnt_a = 0
#     cnt_b = 0
#     for i in range(n):
#         if edge[a][i] == 1:
#             cnt_a += 1
#         if edge[b][i] == 1:
#             cnt_b += 1
#     if cnt_a == 0 or cnt_b == 0:
#         print('no')
#     else:
#         print('yes')
#     edge[a][b] = 1
#     edge[b][a] = 1
#
#
# n = int(read())
# edge = [[0 for _ in range(n)] for _ in range(n)]    # 2차원 배열을 제대로 써주려면 for 문으로 생성해야 하더라...
# order = []
# for _ in range(n-1):
#     lst = list(map(int, read().split()))
#     order.append(lst)
#     edge[lst[0]-1][lst[1]-1] = 1
#     edge[lst[1]-1][lst[0]-1] = 1
#
# for _ in range(int(read())):
#     t, k = map(int, read().split())
#     if t == 1:
#         vertex(k)
#     elif t == 2:
#         bridge(k)