# 이진 검색 트리 - S1

import sys

def postorder(start, end):
    if start > end:
        return

    # start로 부터 값을 늘려나갈때 더 큰 값을 찾지못한경우
    # 다시 끝값부터 재귀를 호출하기 위한 division 설정
    division=end+1

    for i in range(start+1, end+1):
        if node[start]<node[i]:
            division=i
            break

    postorder(start+1, division-1)
    postorder(division, end)
    print(node[start])

sys.setrecursionlimit(10**8)

node=list()
while True:
    try:
        node.append(int(sys.stdin.readline()))
    except:
        break

postorder(0, len(node)-1)