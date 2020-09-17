n = int(input())

def IsPrime(i):
    if i == 0 or i == 1:
        return False
    for j in range(2,i):
        if i % j == 0:
            return False
    return True
def Recursive(i, num):
    if i == 0:
        print(num)
    if IsPrime(i) :
        Recursive(i//10, num)

for i in range(10**(n-1)+1, 10**n,2):
    Recursive(i,i)
        
            
