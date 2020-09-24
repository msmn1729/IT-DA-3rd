def dp(mid):
    start = 1
    #mid의 경우, 8이면 -> 5 + 3해서 2열 3행 ... [k/m][k%m]
    kan[int(k/m)+1][int(k%m)] = mid
    mid_cnt = 0; final_cnt = 0
    a = 1; b = 1
    ways = []; i = 0
    #k까지 갈수있는 방법 찾는거 까지만... 몇 가지인지 알아내는 것까지는 못함
    while len(ways)<=int(k/m)+int(k%m):
        kan[a][b] = 1
        if 0 < a <= int(k/m):
            if 0 < b <= int(k%m):
                ways.append(a+b)
                a += 1
        else:
            if 0 < b <= int(k%m):
                ways.append(a+b)
                b += 1
        if a+b == int(k/m)+int(k%m)+1 : mid_cnt += 1; break
    return(mid_cnt)


n,m,k = list(map(int, input().split()))
#k까지 갈수 있는 경우의 수 * k에서 끝까지 갈수있는 경우의 수
kan = [[0] * (n+1) for i in range(m+1)]
print(dp(k))