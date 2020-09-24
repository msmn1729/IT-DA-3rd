#1개 = W, 0.5개 = H
# 2N개 문자의 문자열 종류
n = int(input())
ar = list(map(int, input().split()))
d = [[0 for _ in range(101)] for _ in range(n+1)] #[n번째 숫자][등식의 값]

d[1][ar[0]] = 1

for i in range(n):
    for j in range(21):
        if d[i][j] > 0:
            if 0<= j - ar[i] <= 20:
                d[i+1][j-ar[i]] += d[i][j]
            if 0<= j+ar[i] <= 20:
                d[i+1][j+ar[i]] += d[i][j]

print(d[n-1][ar[n-1]])