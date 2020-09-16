import sys
#import time

def read_info(): return [int(x) for x in sys.stdin.readline().split()]

def check(x, y, visited):
    if (x, y) in visited and visited[(x, y)] is True:   # 1. index(위치)가 존재하는지, 2.index의 value가 참인지
        return True
    return False

def dfs(N, x, y, dirs, visited):
    if N < 0:
        return 1    # 에러 발생 -> 종료
    if check(x, y, visited):
        return 0    # 정상 종료 / 이미 방문한 곳은 아래 라인 못 내려가고 그냥 True로 남게 됨
    visited[(x, y)] = True  # {(x, y): True}로 출력됨
    #print(visited)
    res = 0
    for dx, dy, dir in dirs:
        res += dir * dfs(N-1, x+dx, y+dy, dirs, visited)
        #print(res)
    visited[(x, y)] = False
    #print(visited)
    return res

def solve(N, dirs, visited):
    return dfs(N, 0, 0, dirs, visited) / 100 ** (N+1)

def main():
    #start = time.time()
    N, dir_E, dir_W, dir_S, dir_N = read_info()
    dirs = (+1, 0, dir_E), (-1, 0, dir_W), (0, -1, dir_S), (0, +1, dir_N)
    visited = {}
    print(solve(N, dirs, visited))
    #print("Time: ", time.time() - start)

main()