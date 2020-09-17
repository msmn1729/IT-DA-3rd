import sys
sys.stdin = open("input.txt","r")

N, p_e, p_w, p_s, p_n = map(int, input().split())
p = [p_e/100, p_w/100, p_s/100, p_n/100]
di = [0,0,-1,1]
dj = [-1, 1, 0,0]
ans = 0
def dfs(i,j,k,prob,visited):
    global ans
    if k==N: #방문 횟수가 n일때
        if len(set(visited)) == N+1:
            ans += prob #
        return
    
    for a in range(4):
        ni, nj = i+di[a], j+dj[a]
        if(ni, nj) not in visited:
            visited.append((ni,nj))
            dfs(i+di[a],j+dj[a],k+1,prob*p[a],visited)
            visited.pop()
            
    dfs(0,0,0,1[(0,0)])
    print('{:.10f}'.format(ans))
