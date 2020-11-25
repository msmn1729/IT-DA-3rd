import sys
read = sys.stdin.readline

for _ in range(int(read())):
    min = 0
    n = int(read())
    rank_list = []
    for _ in range(n):
        rank_list.append(list(map(int, read().split())))
    rank_list = sorted(rank_list)
    tmp = append(rank_list.pop(0))
    for i in rank_list:



    #     if not ans:
    #         ans.append([tmp_s, tmp_m])
    #         min_s = (tmp_s, tmp_m)
    #         min_m = (tmp_s, tmp_m)
    #         continue
    #     if min_s[0] > tmp_s:
    #         if min_m[1] < tmp_m:
    #             min_m = (tmp_s, tmp_m)
    #         ans.append([tmp_s, tmp_m])
    #         flag = False
    #     if min_m[1] > tmp_m:
    #         if min_s[0] < tmp_s:
    #             min_s = (tmp_s, tmp_m)
    #         if flag is True:
    #             ans.append([tmp_s, tmp_m])
    #     print(ans)
    # print(len(ans))



