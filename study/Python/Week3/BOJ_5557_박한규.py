import sys
read = sys.stdin.readline


def oper(n, idx):
    if visited.get((n, idx)): return visited[(n, idx)]
    visited[(n, idx)] = 0
    if idx == len(nums)-1:
        if n == nums[-1]:
            visited[(n, idx)] = 1
        return visited[(n, idx)]

    if n + nums[idx] <= 20:
        visited[(n, idx)] += oper(n+nums[idx], idx+1)
    if 0 <= n - nums[idx]:
        visited[(n, idx)] += oper(n-nums[idx], idx+1)
    return visited[(n, idx)]


if __name__ == '__main__':
    n = int(read())
    nums = list(map(int, read().split()))
    visited = {}
    oper(nums[0], 1)
    print(visited[nums[0], 1])





