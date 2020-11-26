t = int(input())

#for _ in range(t):
    #n = int(input())
    #a = []
    #for i in range(0,n):
        #inputmatrix = list(map(int,input().split()))
        #a.append(inputmatrix)

    #k = n
    #for i in range(0,n,1):
        #for j in range(0,n,1):
            #if (a[i][0] > a[j][0]) and (a[i][1] > a[j][1]):
                #k = k-1
                #break
    #print(k)
            

for _ in range(t):
    n = int(input())
    a = []
    for i in range(0,n):
        inputmatrix = list(map(int,input().split()))
        a.append(inputmatrix)
    print(sorted(a))

        x1 = 0
        x2 = 0
        k = n

    for i in range(0,n-1,1):
        if(a[i][0] > a[i+1][0]):
            x1 = i + 1

    for i in range(0,n-1,1):
        if(a[i][1] > a[i+1][1]):
            x2 = i + 1

    if (x1 == x2) :
        k = k -1
        
