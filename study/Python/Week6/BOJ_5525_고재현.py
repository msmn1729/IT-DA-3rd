n = int(input())
m = int(input())
s = input()

ans = 0
z = 0
i = 1
while i < m-1:
    if s[i-1]=='I' and s[i]=='O' and s[i+1]=='I':
        z = z+1
        if z == n :
            z = z-1
            ans = ans+1
        i = i+1
    else:
        z = 0
    i= i+1
print(ans)
