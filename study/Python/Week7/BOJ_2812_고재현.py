n, k = map(int, input().split())
num = list(input())
answer = []

for i in range(n):
    while k > 0 and answer:
        if answer[-1] < num[i]:
            answer.pop()
            k -= 1
        else:
            break
    answer.append(num[i])
print(''.join(answer[:n-k]))
