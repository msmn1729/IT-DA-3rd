#이분탐색
import sys
n, m =map(int, sys.stdin.readline().split())
x = list(map(int, sys.stdin.readline().split()))

left = max(x)
right = sum(x)

while( left <= right):
    mid = (left + right) /2 
    count = 0
    temp_sum = 0
    for i in range(n):
        temp_sum += x[i]
        