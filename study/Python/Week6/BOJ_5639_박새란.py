x=[]

while(1):
    a = input()
    if(a == ''):
        break
    else:
        x.append(int(a))

t = [ 0 for _ in range(10000)]
idx = 1
for i in range(len(x)):#left subtree from root
    if(x[i] > x[i-1]):
        j = i
        break
    else:
        t[idx] = x[i]
        idx *= 2

idx_sub = idx//2
for i in range(j,len(x)): 
    if x[i] > t[1]:
        j = i
        break
    while(1):
        if(t[idx_sub] <=x[i] and x[i] <= t[idx_sub//2]):
            t[idx_sub + 1] = x[i]
            break
        idx_sub//=2    

idx = 3
for i in range(j, len(x)):#right subtree from root
    if x[i] >x[i-1]:
        j=i
        break
    else:
        t[idx] = x[i]
        idx *= 2

idx_sub = idx//2
for i in range(j,len(x)): 
    while(1):
        if(t[idx_sub*2] <=x[i] and x[i] <= t[idx_sub]):
            t[idx*2 + 1] = x[i]
            break
        idx_sub//=2   

