#오답
import sys

def maxword(arr):
    learned_word = ['a','n','t','i','c']
    myword = 0
    for i in range(n):
        flag = True
        if arr[i].startswith('anta') and arr[i].endswith('tica'):
            arr[i] = arr[i][4:len(arr[i])-4]
            if len(learned_word) < k :
                for j in range(len(arr[i])):
                    if arr[i][j] not in learned_word:
                        learned_word.append(arr[i][j])
        for j in range(len(arr[i])):
            if arr[i][j] not in learned_word :
                flag = False; break
        if flag == True : myword = myword+1
    return myword
            
word = []
n,k = map(int,sys.stdin.readline().split())
for i in range(n):
    word.append(sys.stdin.readline())
    word[i] = word[i][:len(word[i])-1]
print(maxword(word))