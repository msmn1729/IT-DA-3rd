"""
번호의 처음 부분에 다른번호가 포함되면 안됨
case: combination, both 
"""

#시간초과
import sys
t = int(input())
def func(phone):
    for i in range(1,n):
        for j in range(i):
            if phone[j].startswith(phone[i]):
                return 0
            elif phone[i].startswith(phone[j]):
                return 0
            else :
                return 1

if __name__ == "__main__":
    for i in range(t):
        n = int(input())
        phone= []
        for _ in range(n):
            phone.append(sys.stdin.readline().strip())
        print(phone)
        if func(phone):
            print("YES")
        else:
            print("NO")
                  
        
        
