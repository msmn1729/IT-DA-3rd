#시간초과
import sys
n = int(input())
m = int(input())
s = list(sys.stdin.readline())

result = 0
for i in range(m):
    cnt_I = 0
    if(s[i] == 'I'):
        j = i+1
        while(cnt_I < n and j+1 < m):
            if(s[j] == 'O' and s[j+1] == 'I'):
                cnt_I += 1
                j+=2
            else:
                break
        if(cnt_I == n):
            result += 1
print(result)





