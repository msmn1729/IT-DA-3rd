import sys
read = sys.stdin.readline

def oper(w, h):
    if pill[w][h]: return pill[w][h]        # 방문한 적이 있으면 리턴함
    if w == 0: return 1
    else: pill[w][h] = oper(w-1, h+1)       # w가 0이 될 때 까지 알약 쪼개줌
    if h > 0: pill[w][h] += oper(w, h-1)
    return pill[w][h]

if __name__ == '__main__':
    while 1:
        pill = [[0]*31 for _ in range(31)]  # 입력 30 제한 // [[0]*31]*31이랑 다른게 없는데 왜 값이 달라질까...
        n = int(read())
        if n == 0: break
        print(oper(n, 0))