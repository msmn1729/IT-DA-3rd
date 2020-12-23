import sys
n = int(input())
time = []
classroom = []  # index(count)로 교실 지정
index = 0
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    time.append([a, b])

classroom.append(time[0])
count = 0
for i in range(1, n):
    idx = 0
    while(idx <= count):
        start = classroom[idx][0]
        end = classroom[idx][1]
        if end < time[i][0]:
            classroom[idx][0] = time[i][0]
            classroom[idx][1] = time[i][1]
            break
        idx+=1
    if idx >count:
        count+=1
        classroom.append(time[i])

            

print(count+1)
