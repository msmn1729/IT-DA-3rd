from collections import deque
import sys

def size(row,col):
    for i in range(4):
        nx = row + x[i]
        ny = col + y[i]
        if 0<=nx and nx<=N and 0<=ny and ny<=M and trash[nx][ny]==1:
            tmp += 1

x = [0, 0, 1, -1]
y = [1, -1, 0, 0]
#N(세로 길이),M(가로 길이),k(쓰레기 개수)
N,M,k = map(int, input().split())
trash = [[0] * (k+1) for i in range(k+1)]
max_size = 0
for i in range(k):
    r,c = map(int, input().split())
    trash[r][c] = 1

#1인것의 주변 쓰레기 몇개인지 받기
max_size = 0; tmp = 0
for i in range(1,N+1):
    for j in range(1,M+1):
        if trash[i][j]==1:
            size(i,j)
            if tmp > max_size : max_size = tmp

print(max_size)