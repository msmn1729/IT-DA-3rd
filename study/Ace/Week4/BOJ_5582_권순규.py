def LCS(long, short):
    answer = 0
    ll = len(long)
    sl = len(short)
    lcs = [[0] * (sl+1) for _ in range(ll+1)]
    for i in range(1,ll+1):
        for j in range(1,sl+1):
            if long[i-1] == short[j-1]:
                lcs[i][j] = lcs[i-1][j-1] + 1
                
                answer = max(answer,lcs[i][j])
    
    return answer

A = input()
B = input()
if len(A) > len(B):
    print(LCS(A,B))
else:
    print(LCS(B,A))
