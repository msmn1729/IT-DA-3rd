#이분 탐색을 사용하라는데 일단 문제가 이해가 잘 안감,,
# 다시 풀어볼 것 아주 틀림. 
input_list=input().split()
N=int(input_list[0])
M=int(input_list[1])
money_list=[]
money_sum=0
money_max=0
for i in range(N):
    cur_input=int(input())



def binary_search(target, data):
    data.sort()
    start = 0
    end = len(data) - 1

    while start <= end:
        mid = (start + end) // 2

        if data[mid] == target:
            return mid # 함수를 끝내버린다.
        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid -1


            
