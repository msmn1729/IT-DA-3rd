#11000
#인터넷 참고, 다시 풀어볼 것 

import sys
import heapq
si = sys.stdin.readline
 
 
def main():
    cnt, n, pq, rooms = 1, int(si()), [], []
    for _ in range(n):
        [a, b] = [int(e) for e in si().split()]
        heapq.heappush(pq, (a, b))
 
    heapq.heappush(rooms, heapq.heappop(pq)[1])
    while pq:
        curr = heapq.heappop(pq)
        if curr[0] < rooms[0]:
            cnt += 1
        else:
            heapq.heappop(rooms)
        heapq.heappush(rooms, curr[1])
    print(cnt)
 
 
if __name__ == '__main__':
    main()

#heapq 모듈은 보통 리스트를 최소 힙처럼 다룰 수 있도록 도와주는 모듈이다. 따라서 빈 리스트를 생성한 후 heapq 모듈의 함수 호출 시 리스트를 인자로 넘겨 최소 힙 자료구조로 동작하도록 한다.
#즉, heapq 모듈을 이용해 원소를 추가, 삭제한 리스트는 최소 힙이라고 할 수 있다.
#힙에 원소 추가: heapq.heappush(리스트명, 원소) -> 리스트에 원소를 추가
#힙의 원소 삭제: heapq.heappop(리스트명) -> 리스트에서 가장 작은 원소를 삭제
#* heapq 모듈에 사용되는 리스트는 python의 보통 리스트이므로 인덱스를 통해 접근해서 원소를 읽을 수 있음-> 주의사항: 두 번째 작은 원소는 heap[1]이 아닐 수 있음
