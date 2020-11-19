def LCS(A,B,C):
    answer = 0
    
    al = len(A)
    bl = len(B)
    cl = len(C)
    lcs = [[[0] * (cl+1) for _ in range(bl+1)] for _ in range(al+1)]
    for i in range(1,al+1):
        for j in range(1,bl+1):
            for k in range(1,cl+1):
                if A[i-1] == B[j-1] and B[j-1] == C[k-1]:
                    lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1
                    answer = max(answer,lcs[i][j][k])
                else:
                    lcs[i][j][k] = max(lcs[i-1][j-1][k],lcs[i][j-1][k-1],lcs[i-1][j][k-1],lcs[i-1][j][k],lcs[i][j-1][k],lcs[i][j][k-1])
    
    return answer
    
A = input()
B = input()
C = input()
print(LCS(A,B,C))
