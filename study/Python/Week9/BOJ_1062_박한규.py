import sys
read = sys.stdin.readline

N, K = 0, 0
isLearn = [False] * 26
words = []
MAX_LEARN = 0


def learn_alpha(alpha, learn_cnt):
    global N, K, isLearn, words, MAX_LEARN
    if learn_cnt == K - 5:
        tmp = 0
        for word in words:
            flag = True
            for w in word:
                if not isLearn[ord(w) - ord('a')]:
                    flag = False
                    break
            if flag:
                tmp += 1
        MAX_LEARN = max(tmp, MAX_LEARN)
        return

    for i in range(alpha, 26):
        if not isLearn[i]:
            isLearn[i] = True
            learn_alpha(i, learn_cnt + 1)
            isLearn[i] = False


def solution():
    global N, K, isLearn, words
    N, K = map(int, read().strip().split())
    if K < 5:
        return 0
    elif K == 26:
        return N

    for _ in range(N):
        word = read().strip()
        words.append(word.replace("antci", ""))

    isLearn[ord('a') - ord('a')] = True
    isLearn[ord('c') - ord('a')] = True
    isLearn[ord('i') - ord('a')] = True
    isLearn[ord('n') - ord('a')] = True
    isLearn[ord('t') - ord('a')] = True

    learn_alpha(alpha=0, learn_cnt=0)
    return MAX_LEARN

print(solution())