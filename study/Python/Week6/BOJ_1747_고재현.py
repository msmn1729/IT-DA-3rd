#1747

import math

def is_prime_number(x):
    for i in range(2, int(math.sqrt(x))+1):
        if x % i == 0:
            return False
        return True



n = int(input())

res = 0

for i in range(n,1000001):
    if i == 1:
        continue
    if str(i) == str(i)[::-1]:
        if is_prime_number(i) == True:
            res = i
            break

if res == 0:
    res = 1003001
    
print(res)
