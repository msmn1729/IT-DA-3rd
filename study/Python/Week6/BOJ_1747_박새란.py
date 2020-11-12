n = int(input())
x = list(str(n))

def prime_number(number):
    if number != 1:
        for i in range(2,number):
            if number % i == 0:
                return False
    else:
        return False
    return True
if(n%2 == 0):
    n+=1

while(1):
    f= 1
    x = list(str(n))
    print(x)
    if prime_number(n) :#소수
        for i in range(len(x)//2): #팰린드롬
            if x[i] != x[len(x)-i-1]:
                f=0
                break
        if f==1:
            print(n)
            break
    n+=2        

