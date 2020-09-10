from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    stack = deque()
    is_my_friend[start] = 1
    stack.append(start)
    while stack:
        a = stack.popleft()
        for i in range(1, number_of_people+1):
            #[me][i] -> 1,2 / 1,3 이런식으로 확인하는거임
            #만약 아직 is_my_friend칸에도 확인되지 않았는데 친구라고 입력받은 상태라면
            if is_my_friend[i] == 0 and me_and_friend[a][i] == 1:
                stack.append(i)
                #친구인지 카운트 하기 위해 값을 임의로 주는것
                is_my_friend[i] = is_my_friend[a] + 1


number_of_people = int(input())
number_of_cases = int(input())
me_and_friend = [[0] * (number_of_people+1) for i in range(number_of_people+1)]
is_my_friend = [0 for i in range(number_of_people+1)]

for i in range(number_of_cases):
    me, friend = map(int, input().split())
    me_and_friend[me][friend] = 1
    me_and_friend[friend][me] = 1

bfs(1)

friend_count = 0
for i in range(2, number_of_people+1):
    #1,2까지 더해서 3정도인거까지만이 친구, 친구의친구 정도 관계이므로 friend_count로 책정가능해지는것
    if is_my_friend[i] < 4 and is_my_friend[i] != 0:
        friend_count += 1
print(friend_count)