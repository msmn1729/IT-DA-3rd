from math import sqrt
n = int(input())
while True:
    if n == 1:
        print(2)
        break
    if str(n) == str(n)[::-1]:
        flag = True
        for i in range(2, int(sqrt(n))+1):
            if n % i == 0:
                flag = False
                break
        if flag is True:
            print(n)
            break
    n += 1



# 에라토스테네스의 체 안됨

# nums = [1 for _ in range(1000001)]
# prime = []
# for i in range(2, 1000001):
#     if nums[i] == 1:
#         prime.append(i)
#         for j in range(i+i, 1000001, i):
#             nums[j] = 0
#
# while True:
#     if n == 1:
#         print(2)
#         break
#     if str(n) == str(n)[::-1]:
#         flag = True
#         for i in prime:
#             if n % i == 0:
#                 flag = False
#                 break
#         if flag is True:
#             print(n)
#             break
#     n += 1

