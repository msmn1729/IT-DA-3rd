import sys
read = sys.stdin.readline

n = int(read())
m = int(read())
s = read()
num = 0
cnt = 0
i = 0
while i < m-2:          # for문으로 구현하면 i+=1 부분에서 제대로 작동 안하는 듯 함..
    if s[i] == 'I' and s.startswith("OI", i+1):
        num += 1
        if num == n:
            cnt += 1
            num -= 1
        i += 2
    else:
        num = 0
        i += 1
print(cnt)




