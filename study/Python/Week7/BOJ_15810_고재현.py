#한규오빠꺼 아주 참고 매우 .. 대단합니당 엄지척
#아니 이진탐색은 도저히 내 머릿속에서 응용될 생각을 못한다... 이해에 초점을 둬야겠다.

import sys
read = sys.stdin.readline

n, m = map(int, read().split())
a = list(map(int, read().split()))

left = min(a) #이진탐색을 위해선 left right를 정해줘야하는데 여기선 가짱 빨리 부는애가 소풍선 한개만 완성하는 아주 최소의 시간 설정

right = min(a)*m #풍선 m개를 생성하려면 아무리 늦어도 이 시간은 걸림 ( 왜 max(a)아니지? -> 최소값을 구하는거니까 굳이 max일 필요 없음.이건 풍건의 갯수 차이 ) 

while left < right: #left right 자리가 바뀌지 않을 때까지 (근데 <=는 왜 안되는거죠,,?)
    mid = (left + right) // 2 #전형적인 이진탐색 코드 
    cnt = 0
    for i in a:
        cnt += mid // i #걸리는 시간에서 각 스태프의 풍선제작시간을 나눠주면 그 시간동안 몇개를 만들 수 ㅇ있나 알 수 있음
    if cnt >= m: #만들 수 있는 풍선의 갯수가 만들어야하는 풍선갯수보다 많거나 같으면,
        right = mid #right를 mid까지 줄여줘!
    else: left = mid+1 # 그렇지 않으면 left를 mid+1까지 늘려줘! ( 여기서 왜 mid면 안되는거죠..?
    
print(right)
