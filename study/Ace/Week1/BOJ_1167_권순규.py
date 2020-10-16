# 트리의 지름
import sys

def dfs(start, length):
    global answer, end
    if visited[start]:
        return
    visited[start] = True
    
    for i in graph[start]:
        dfs(i[0],length + i[1])
    
    if answer < length:
        answer = length
        end = start
        
if __name__ == "__main__":
    V = int(input())
    graph = [[] for _ in range(V+1)]
    visited = [False for _ in range(V+1)]
    answer = 0
    end = 0
    for _ in range(1, V+1):
        tmp = list(map(int, sys.stdin.readline().split()))
        
        for j in range(1, len(tmp)-2, 2):
            graph[tmp[0]].append((tmp[j], tmp[j+1]))
    
    #for i in graph:
    #    print(i)
    
    dfs(1,0)
    visited = [False for _ in range(V+1)]
    dfs(end,0)

    print(answer)
