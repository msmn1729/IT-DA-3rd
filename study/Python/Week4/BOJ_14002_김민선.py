n = int(input())
a = list(map(int, input().split()))
count = 0; tmp = 0
out = [0 for i in range(n)]

#더 큰 게 나오면 그때서야 카운트 + out리스트에 그 수들 저장해서 출력
#이렇게 푸는게 맞나..?
for i in range(n):
    if tmp < a[i] :
        out[count] = a[i]
        count += 1
        tmp = a[i]
print(count)
for i in range(n):
    if out[i]==0 : break
    print("%d "%(out[i]),end='')