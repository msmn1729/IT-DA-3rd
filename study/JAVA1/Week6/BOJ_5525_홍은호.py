N = int(input())
M = int(input())
S = input()

cnt = 0
index = 0
ans = 0

while index < M:
    if S[index:index+3] == "IOI":
        cnt += 1
        index += 2
        if cnt >= N:
            ans += 1
    else:
        index += 1
        cnt = 0

print(ans)
