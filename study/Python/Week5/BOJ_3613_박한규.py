import sys
read = sys.stdin.readline

def toJAVA():
    # 첫 문자가 _ 혹은 대문자, 마지막 문자가 _
    if string[0].isupper() or string[0] == "_" or string[-1] == "_":
        return False
    else:
        res = string[0]

    for i in range(1, len(string)):
        # C++ 인데 대문자 있는 경우
        if string[i].isupper():
            return False
        # _가 연속으로 나오는 경우
        if string[i] == "_":
            if string[i+1] == "_": return False
        elif string[i-1] == "_":
            res += string[i].upper()
        else:
            res += string[i]
    return res

def toC():
    # 첫 문자가 _ 혹은 대문자, 마지막 문자가 _
    if string[0].isupper():
        return False
    else:
        res = string[0]

    for i in range(1, len(string)):
        if string[i].isupper():
            res += "_"
            res += string[i].lower()
        else:
            res += string[i]
    return res


string = read()
string = string[:-1]
res = string[0]
if "_" in string:
    res = toJAVA()
else:
    res = toC()

if res is False:
    print('Error!')
else:
    print("{}".format(res))
