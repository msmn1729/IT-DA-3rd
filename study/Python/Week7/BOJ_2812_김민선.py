import sys

N,K = map(int,sys.stdin.readline().split())
#split은 안되고 strip은 되는...?
s = list(sys.stdin.readline().strip())
stack = []; tmpk = K
for i in range(N):
    while tmpk > 0 and stack and stack[-1] < s[i]:
        stack.pop()
        tmpk -= 1
    stack.append(s[i])
print(''.join(stack[:N-K]))