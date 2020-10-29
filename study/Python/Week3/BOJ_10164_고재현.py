# 10164 고재현
n,m,k = input().split()
n = int(n)
m = int(m)
k = int(k)

z_ans = 1
z_ans2 = 1
z_ans3 = 1
if k == 0:
    for i in range(m-1,0,-1):
        z_ans *= i

    for i in range(n-1,0,-1):
        z_ans2 *= i

    for i in range(n+m-2,0,-1):
        z_ans3 *= i
    print(z_ans3//(z_ans2 * z_ans))

else: 
        

    a = k % m -1
    if (k % m == 0) :
        b = (k // m ) -1

    else :
        b = k // m



    ans= 1
    ans2 = 1
    ans3 = 1

    for i in range (a,0,-1):
        ans = ans * i
    

    for j in range (b,0,-1):
        ans2 = ans2 * j

    for z in range(a+b,0,-1):
        ans3 = ans3 * z
    

    f_ans = (ans3//(ans * ans2))


    c = m-a-1
    d = n -b -1



    an= 1
    an2 = 1
    an3 = 1

    for i in range (c,0,-1):
        an = an * i


    

    for j in range (d,0,-1):
        an2 = an2 * j

    for z in range(c+d,0,-1):
        an3 = an3 * z



    f_ans2 = (an3//(an * an2))


    print(f_ans * f_ans2)

    
