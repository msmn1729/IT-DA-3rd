def LCS(long, short):
    answer = 0
    answerSTR = ''
    ll = len(long)
    sl = len(short)
    lcs = [[0] * (sl+1) for _ in range(ll+1)]
    for i in range(1,ll+1):
        for j in range(1,sl+1):
            if long[i-1] == short[j-1]:
                lcs[i][j] = lcs[i-1][j-1] + 1
                answer = max(answer,lcs[i][j])
            else:
                lcs[i][j] = max(lcs[i][j-1],lcs[i-1][j])
    
    if answer == 0:
        return answer, ''
    
    tmp = answer
    for i in range(ll,0,-1):
        for j in range(sl,0,-1):
            if lcs[i][j] == tmp and lcs[i][j-1] == tmp-1 and lcs[i-1][j] == tmp-1 and lcs[i-1][j-1] == tmp-1:
                answerSTR = short[j-1] + answerSTR
                tmp -= 1
                break
    
    return answer, answerSTR
                    
    

A = input()
B = input()
a, b = LCS(B,A)
print(a)
if b:
    print(b)
