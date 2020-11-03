# 전화번호목록 - G4

import re
import sys

sys.setrecursionlimit(30000)

T=int(sys.stdin.readline())

def find_prefix(val_list, sentence):
    yn='YES'

    for i in val_list:
        for a in re.finditer(i, sentence):
            pos=a.start()
            if sentence[pos+len(i)] != '/':
                yn='NO'
                break
    
    return yn

for _ in range(T):
    n=int(sys.stdin.readline())
    val=list()
    word='/'
    for _ in range(n):
        num=sys.stdin.readline().rstrip()
        val.append(num)
        word+=num+'/'
    
    result=find_prefix(val,word)
    print(result)