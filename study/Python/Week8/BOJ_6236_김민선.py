input_list=input().split()
N=int(input_list[0])
M=int(input_list[1])
money_list=[]
money_sum=0
money_max=0
for i in range(N):
    cur_input=int(input())
    money_list.append(cur_input)
    money_sum+=cur_input
    if cur_input > money_max:
        money_max=cur_input
left=money_max                          #시작점 (최소값)
right=money_sum                         #끝점 (최대값)
cur_best=money_sum
while left<=right:                      #이분 탐색 시작
    mid=int((left+right)/2)             #mid: 현재 시도하는 K 값
    cur_count=0                         #현재 탐색에서의 인출 횟수 count
    cur_sum=0                           #현재 탐색에서의 부분 합
    for i in range(N):                  #리스트 돌면서 탐색
        cur_sum+=money_list[i]
        if cur_sum>mid:                 #mid 값 초과하면 횟수 +1
            cur_count+=1
            cur_sum=money_list[i]
    if cur_sum>0:
        cur_count+=1                    #마지막에 남으면 횟수 1 추가
    if cur_count>M:                      #인출 횟수가 M보다 크면 안 됨.
        left=mid+1                       #탐색 범위를 뒤쪽으로 이동
    else:                                #인출 횟수가 M보다 작거나 같은 경우 조건은 만족
        if mid<cur_best:
            cur_best=mid                 #cur_best 값보다 현재의 K 값이 더 작으면 업데이트
        right=mid-1
print(cur_best)
#[출처] [백준 6236번] 용돈 관리, 이분 탐색 (Binary Search) 기초 (Python 코드 첨부, 난이도: Silver 3)|작성자 SH



