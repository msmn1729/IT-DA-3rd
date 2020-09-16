from collections import deque

def is_prime(num):
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

def bfs_prime(prime, n):
    while prime:
        num = prime.popleft()
        for i in range(1, 10):
            tmp = num * 10 + i
            if tmp > pow(10, n):
                prime.appendleft(tmp//10)
                return prime
            if is_prime(tmp) == False:
                continue
            prime.append(tmp)
    return prime

def main():
    n = int(input())
    root = deque([2, 3, 5, 7])
    prime = bfs_prime(root, n)
    for i in range(len(prime)):
        print(prime[i])

main()
