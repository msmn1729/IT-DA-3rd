import sys

n = int(input())
tree = [[] for _ in range(n)]

for i in range(n-1):
    
    a,b = map(int,sys.stdin.readline().split())
    tree[a-1].append(b-1)
    tree[b-1].append(a-1)
    
n = int(input())

for _ in range(n):
    a,b = map(int,sys.stdin.readline().split())
    
    if a == 2:
        print('yes')
        
    else:
        
        if len(tree[b-1]) == 1:
            print('no')
            
        else:
            print('yes')
