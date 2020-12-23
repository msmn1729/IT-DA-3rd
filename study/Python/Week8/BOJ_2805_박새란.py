import sys
n,m = map(int, sys.stdin.readline().split())
tree = list(map(int,sys.stdin.readline().split()))

low = 0
high = sum(tree)
def cut(tree,mid):
    result = 0
    for i in tree:
        if i > mid:
            result += (i - mid)
    return result

while low < high: 
    mid = (low + high+1)//2 #기준 높이 이분탐색
    result = cut(tree, mid)   #잘린 나무 높이 합   
    if result < m:
        high = mid-1
    else:
        low = mid
print(high)
        