D,N = map(int,input().split())
oven = list(map(int,input().split()))
pizza = list(map(int,input().split()))
j = 0

for i in range(N):
    while j < D:
        if oven[j] > 0:
            if pizza[i] <= oven[j] :
                oven[j] -= pizza[i]
                break
            else :
                j += 1
        elif oven[j] == 0 :
            j += 1
if 0 not in oven : print(0)
else : print(j+1)