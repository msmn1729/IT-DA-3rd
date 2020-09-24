#1개 = W, 0.5개 = H
# 2N개 문자의 문자열 종류

dp = [[0 for _ in range(31)] for _ in range(31)]
def pill(w,h): #(w,h-1),(w-1, h+1) 
    if w<0:
        return 0
    if w == 0 and h == 0:
        return 1
    if dp[w][h] != 0 : #알약이 w,h남았을때 만들수있는 문자열 개수
        return dp[w][h]
    if(w > 0) : #한알
        dp[w][h] += pill(w-1, h+1)
    if(h > 0): #반알
        dp[w][h] += pill(w,h-1)
    return dp[w][h]

n = int(input())   
while(n!=0):
    print(pill(n, 0))
    n = int(input())
