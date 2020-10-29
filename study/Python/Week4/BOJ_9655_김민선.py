N = int(input())
# 1 -> SK
# 2 -> CY
# 3 -> 1, 0, 1, 0, 1 ...
# 2개만 남았을 때 CY가 다 가져갈 수 없는 것
if N%2 != 0 : print("SK")
else : print("CY")