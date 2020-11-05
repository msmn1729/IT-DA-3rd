import sys

def solution(numbers):
    numbers.sort() # 사전순으로 정렬
    for i in range(len(numbers)-1): #i번째와 i+1번째만 비교
        if numbers[i] in numbers[i+1]: 
            return "NO"
    return "YES"


t=int(input())

for i in range(t):
    numbers=[] #초기화를 위해 for문 안에다가 넣음
    n=int(input())
    for _ in range(n):
        numbers.append(sys.stdin.readline().strip())
        
    print(solution(numbers))
    
    

