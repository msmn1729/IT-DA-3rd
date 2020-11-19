N = int(input())
freq = dict()

for _ in range(N):
    string = input()
    N = len(string)
    
    for ch in string:
        if not freq.get(ch):
            freq[ch] = 0
        freq[ch] += 10**(N-1)
        N -= 1

rank = sorted(freq.items(),key=lambda x:-x[1]) # x는 (알파벳,점수)의 튜플
start = 9
score=0
for i in rank:
    score += (start * i[1])
    start -= 1
print(score)
