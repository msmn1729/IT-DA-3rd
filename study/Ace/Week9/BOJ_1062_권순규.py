def func(k,prev):
    global answer
    
    if k == K:
        n = 0
        for word in words:
            flag = True
            for ch in word:
                if not included[ord(ch)-ord('a')]:
                    flag = False
                    break
            if flag:
                n += 1
        answer = max(answer,n)
        return
        
    for i in range(prev+1,26):
        if not included[i]:
            included[i] = True
            func(k+1,i)
            included[i] = False
            
from itertools import combinations
import sys
if __name__ == "__main__":
    N, K = map(int,input().split())
    if K < 5:
        print(0)
        sys.exit(0)
    elif K == 26:
        print(N)
        sys.exit(0)
        
    words = []
    included = [False] * 26
    answer = 0
    for _ in range(N):
        words.append(input()[4:-4])
    
    included[ord('a')-ord('a')] = True
    included[ord('c')-ord('a')] = True
    included[ord('i')-ord('a')] = True
    included[ord('n')-ord('a')] = True
    included[ord('t')-ord('a')] = True

    func(5,-1)

    print(answer)
