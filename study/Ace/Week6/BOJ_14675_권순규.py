import sys

def dfs(start):
    
    if len(tree[start]) >= 2:
        cut_vertex[start] = True
    
    for i in tree[start]:
        if not visited[i]:
            visited[i] = True
            dfs(i)

if __name__ == "__main__":
    N = int(input())
    tree = [[] for _ in range(N+1)]
    cut_vertex = [False] * (N+1)
    visited = [False] * (N+1)
    
    for i in range(1,N):
        a,b = map(int,sys.stdin.readline().split())
        tree[a].append(b)
        tree[b].append(a)
            
    dfs(1)
        
    q = int(input())
    for _ in range(q):
        t, k = map(int,sys.stdin.readline().split())
        if t == 1:
            if cut_vertex[k]:
                print('yes')
            else:
                print('no')
        else: # 트리는 사이클이 존재하지 않으므로 모든 간선이 단절선이 된다.
            print('yes')
