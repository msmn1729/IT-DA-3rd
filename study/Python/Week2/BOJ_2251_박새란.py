from collections import deque

#node의 형태는 (a,b,c) 물의양
ans = [] #남은c의 물의양
Max_a,Max_b,Max_c = map(int, input().split())
def bfs(a,b,c):
    visited=[] #방문한 node저장
    Max = [a,b,c]
    q = deque()
    q.append([0,0,c])
    while q:
        n = q.popleft()
        if n[0] == 0:
            ans.append(n[2])
        else:
            for i in range(3):
                nfrom = i
                nto = (i+1)%3
                if n[nfrom] + n[nto] > Max[nto]: #nto가 가득찰 때
                    n[nfrom] -= Max[nto] - n[nto]
                    n[nto] = Max[nto]
                else: #nfrom이 빌 때
                    n[nfrom] = 0
                    n[nto] += n[nfrom]
                if n not in visited:
                    visited.append(n)
                    q.append(n)

            for i in range(3):
                nfrom = i
                nto = (i+2)%3
                if n[nfrom] + n[nto] > b: #nto가 가득찰 때
                    n[nfrom] -= Max[nto] - n[nto]
                    n[nto] = Max[nto]
                else: #nfrom이 빌 때
                    n[nfrom] = 0
                    n[nto] += n[nfrom]
                if n not in visited:
                    visited.append(n)
                    q.append(n)

    return list(set(ans))

print(bfs(Max_a,Max_b,Max_c))

