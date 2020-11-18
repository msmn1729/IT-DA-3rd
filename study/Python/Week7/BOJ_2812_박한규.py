# 반례
# 6 4
# 198794
from _collections import deque
import sys
read = sys.stdin.readline

n, k = map(int, read().split())
num = deque(map(str, read().strip()))
ans = list(num.popleft())

while num:
    tmp = num.popleft()
    while ans and ans[-1] < tmp and k > 0:
        ans.pop()
        k -= 1
    ans.append(tmp)
if k > 0:
    ans = ans[:-k]
print("".join(ans))
