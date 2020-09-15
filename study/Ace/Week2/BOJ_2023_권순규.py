# 신기한 소수
N = 0

def isPrime(n):
    for i in range(2,n):
        if n % i == 0:
            return False
    return True

def findPrime(n, num):
    if n == N:
        print(num)
        return
    
    if n == 0:
        for i in [2,3,5,7]:
            findPrime(n+1,num+str(i))
    else:
        for i in [1,3,5,7,9]:
            if isPrime(int(num+str(i))):
                findPrime(n+1,num+str(i))


if __name__ == "__main__":
    N = int(input())
    findPrime(0, '')
    

