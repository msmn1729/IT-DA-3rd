# 의현오빠꺼 아주 참고 매우 참고 이건 도저히 내머리에서 안나옴... 심지어 의현오빠 풀이를 보는데도 머리가 안따라줌
#그래서 한줄 한줄 풀이를 적어보려함..

import sys
read = sys.stdin.readline

d,n = map(int,read().split())
oven = list(map(int,read().split()))
pizza = list(map(int,read().split()))

for i in range(1,d):
    oven[i]= min(oven[i],oven[i-1]) #여기까진 풀었음 그 뒤가 문제.


right = d-1 #맨 밑에서부터 확인하기 위해서 

for p in pizza: #n개의 피자를 하나씩 위치를 찾아줄 것임
    result = 0
    for i in range(right,-1,-1): #거꾸로 거슬러 올라가
        if oven[i] >= p : #오븐이 피자보다 크거나 같아서 피자가 들어갈 수 있으면,
            result = i+1 # 반죽의 위치는 거기야!(인덱스는 0부터 시작이고 오븐 위치는 1부터 시작인 것 유의)
            right = i-1 # 그 다음 피자 반죽은 그 위에부터 들어 갈 수 있으니까 i-1해줌
            break #해당 피자반죽은 위치를 찾았으므로 다음 피자반죽으로 넘어가!
        
    if result == 0: #어느 한 반죽이라도 오븐에 못들어가면 이 프로그램 끝내버려. 첫번째 for문 나가는 것임. 
        break

print(result)
