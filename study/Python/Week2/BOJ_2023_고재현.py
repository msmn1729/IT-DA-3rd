#2023 신기한 소수
def isPrime(n): 
    if n < 2: 
        return False 
    if n == 2: 
        return True 
    if n % 2 == 0: 
        return False 
    l = round(n ** 0.5) + 1 
    for i in range(3, l, 2): 
        if n % i == 0: 
            return False 
    return True

"""
만약 어떤 자연수 N이 a로 나눠진다면 N = a * b 로 표현할 수 있을 것이다.
그렇다면 N 은 a 로도 b 로도 나눠진다는 말이다.
즉 N의 제곱근 r 을 기준으로 곱해서 N이 될 수 있는 약수들이 같은 개수로 분포한다는 말이다.
따라서 N이 소수인지를 알고 싶으면 N의 제곱근까지만 검사해보면 된다.

출처: https://53perc.tistory.com/entry/파이썬-소수-판별하기 [53Percent]

"""


def check(frist, n) :
    
    if(n == 0) :
        print(frist)

    for i in range (1,10,2) :
        tmp = frist * 10 + i
        if (isPrime(tmp)) :
            check(tmp, n-1)


n = int(input())

first = [2, 3, 5, 7]
for i in range(0,4) :
    check(first[i], n-1)

