def prime_number(number):
    if number != 1:
        for i in range(2, number):
            if number % i == 0:
                return False
    else:
        return False
    return True

N = int(input())
ans = 0

for i in range(N,1000001):
    if i == 1:
        continue
    if str(i) == str(i)[::-1]:
        if prime_number(i):
            ans = i
            break

if ans == 0:
    ans = 1003001

    
print(ans)
