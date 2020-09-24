#W는 약의 개수까지만 가능
#H가 나오려면 그 동안 나온 H의 횟수가 W의 횟수보다 작아야함
import random
num = int(input())
a = list(map(int, input().split()))
index = 0
w_cnt = 0; h_cnt = 0; case = ['W','H']
while True:
    if a[index] == 0 and index == len(a)-1 : break
    tmp = [[0] for i in range(a[index]*2)]
    for i in range(len(tmp)):
        if i==0: tmp[i] = 'W'; w_cnt+=1
        else:
            if h_cnt < w_cnt: tmp[i] = 'H'; h_cnt+=1
            else : tmp[i] = 'W'; w_cnt += 1
    print()
    index += 1