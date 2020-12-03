from itertools import combinations
import sys
input = input
n, k = map(int, input().split())

if k < 5:
    print(0)
    sys.exit()
if k == 26:
    print(n)
    sys.exit()
text = [] #필수로 들어가 있는 애들 뺸 나머지 글자 
alpha = set('acint') #겹치는게 있으면 안되니까 집합 자료형 써줌
check = set()#text에 있는 글씨들을 중복 없이 합친 것

for _ in range(n):
    word = set(input().strip()[4:-4])#필수로 들어가 있는 것들 빼주기 
    text.append(word)
    check |= word # 합집합
check -= alpha
tmp = 0
#print(text)
#print(check)

for c in combinations(check, min(k-5, len(check))): #check에 있는 애들 을 min(k-5,len(check)수만큼 조합 시켜)
    count = 0
    subset = set(c) | alpha
    for word in text:
        if word <= subset:
            count += 1
    if tmp < count:
        tmp = count
print(tmp)

#combination 예시
#from itertools import combinations
#a = [1,2,3]
#combi = combinations(a,2)
    
#print(list(combi))
#결과
#[(1,2),(1,3),(2,3)]
