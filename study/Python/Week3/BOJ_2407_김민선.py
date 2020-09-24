import math
n,m = list(map(int, input().split()))
#// : 정수 나눗셈, / : float 나눗셈
res = math.factorial(n) // ((math.factorial(n - m)) * (math.factorial(m)))
print(res)