n = int(input())
line = list(map(int,input().split()))
tmp = 0; count = 0
#맨 앞에는 1이 아니면 1로 하는 게 맞고
#맨 뒤는 현재 맨 뒤 숫자보다 1 더 큰 숫자가 오는게 맞음
#시간 초과
for i in range(n):
    for j in range(n):
        if line[0] != 1 :
            tmp = line[0]
            if line[j] == 1:
                line[0] = line[j]
                line[j] = tmp
                count += 1
        else:
            tmp = line[n-1]
            if line[n-1]+1 == line[j] :
                line[n-1] = line[j]
                line[j] = tmp
                count += 1

print(count)