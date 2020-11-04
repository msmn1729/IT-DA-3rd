for _ in range(int(input())):
    n = int(input())
    lst = []

    for _ in range(n):
        lst.append(input())

    lst.sort()
    
    flag = True
    for i in range(len(lst)-1):
        if lst[i] == lst[i+1][:len(lst[i])]:
            flag = False
            break

    if flag:
        print('YES')
    else:
        print('NO')
