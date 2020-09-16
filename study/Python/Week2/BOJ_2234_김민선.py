from collections import deque
#1600
def bfs(a,b):
    area = 1
    q = deque()
    q.append([a, b])
    visited[a][b] = True
    while q:
        karo, sero = q.popleft()
        for i in range(4):
            k = karo + x[i]
            s = sero + y[i]
            if 0 <= k < m and 0 <= s < n and visited[k][s] == False:
                if i == 0 or i == 1 or i == 2 or i == 3:
                    # & : 비트 연산자. 2진수로 자리수 비교해서 둘다 1이면 1 (보통 더 작은 수로 결과가 나오는듯)
                    # 1,2,4,8이 포함 되어있다면 dirt[i]로 값이 나올것
                    if dirt[i] & wall[karo][sero] : continue
                #방문하는 곳은 모든 True로
                visited[k][s] = True
                q.append([k, s])
                area += 1
    return area

#동서남북 ... -> 사분면 생각하고 가로세로 생각하고
x = [0, -1, 0, 1]
y = [-1, 0, 1, 0]
dirt = [1, 2, 4, 8]
#n,m받고 숫자받기 / visited : 그곳에 방문했는지 true,false로 구분
n,m = map(int, input().split())
wall = [list(map(int, input().split())) for i in range(m)]
visited = [[0] * n for i in range(m)]
#maximum : 방의 넓이 최대 / room : 방 개수
maximum = 0; room = 0

for i in range(m):
    for j in range(n):
        #방문하지 않을 경우 : 맨처음, True 한번 쫙 훑고 난 뒤 리턴 됐을때 그 다음 값
        if visited[i][j] == False:
            room += 1
            maximum = max(maximum, bfs(i, j))

print(room)
print(maximum)
#마지막은 못품