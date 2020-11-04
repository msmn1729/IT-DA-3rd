"""
c++ : all small letters
    division = _
java: 
    first word = all small letters
    else words=  first letter ->capital letter, else -> small letters
    no division
"""
"""
오류 케이스
1. __,_시작, _끝
2. _와 대문자 

모든 문자가 소문자인 경우 오류가 아니다.
"""
import sys
convert = []
sentence = list(input())
def IsJava(sentence):
    for x in sentence:
        if x.isupper():
            return 1
    return 0
def IsCpp(sentence):
    for i in range(len(sentence)):
        if sentence[i] == '_':
            return 1
    return 0
def nolan(sentence):
    if sentence[0].isupper():
        return 1
    if sentence[0] == '_':
        return 1
    if sentence[len(sentence)-1] == '_':
        return 1
    if IsJava(sentence) and IsCpp(sentence):
        return 1
    for i in range(len(sentence)):
        if sentence[i] == '_' and sentence[i+1] == '_':
            return 1
    return 0

def ConvertToJava(sentence):
    f = 0
    for x in sentence:
        if x == '_':
            f = 1
        elif f == 1:
            f = 0
            convert.append(x.upper())
        else:
            convert.append(x)
def ConvertToCpp(sentence):
    for x in sentence:
        if 'A'<=x and x<='Z':
            convert.append('_')
            convert.append(x.lower())
        else:
            convert.append(x)

if __name__ == "__main__":
    if nolan(sentence):
        print("Error!")
    elif IsJava(sentence) :
        ConvertToCpp(sentence)
        print(''.join(convert))
    elif IsCpp(sentence):
        ConvertToJava(sentence)
        print(''.join(convert))
    else: print(''.join(sentence))
