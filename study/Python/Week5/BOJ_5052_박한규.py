import sys
read = sys.stdin.readline
for _ in range(int(read())):
    cons = True
    number = [read()[:-1] for _ in range(int(input()))]
    number = sorted(number)
    for i in range(len(number)-1):
        if len(number[i]) < len(number[i+1]):
            if number[i] == number[i+1][:len(number[i])]:
                cons = False
                break
    if cons is False:
        print("NO")
    else:
        print("YES")




