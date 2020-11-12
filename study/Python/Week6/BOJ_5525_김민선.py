#시간 초과
def search():
    res = 'I'; compare = ''; count = 0
    for i in range(n):
        res += 'OI'
    for i in range(m):
        compare += s[i]
        if len(compare) == 2*n+1 :
            if compare == res :
                count += 1
            compare = compare[1:]
    return count

n = int(input())
m = int(input())
s = input()
print(search())