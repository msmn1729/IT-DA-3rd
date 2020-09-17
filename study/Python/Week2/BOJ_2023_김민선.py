def is_prime(a):
    #순서를 바꿨더니 됐다...
    #제곱근
    for i in range(2,int(int(a)**0.5)+1):
        if int(a)%i==0: return
    if len(a)== n : print(a); return
    for j in odd:
        is_prime(a+j)

n = int(input())
checker = ['2','3','5','7']
odd = ['1','3','5','7','9']
for i in checker:
    #2,3,5,7 첫째자리
    is_prime(i)