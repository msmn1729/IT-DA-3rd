def cpp(arr):
    #cpp -> java
    #_없애고 대문자화
    #대문자가 있으면 error! 출력
    if arr[0] == "_" or arr[-1] == "_" or "__" in arr:
        return "Error!"
    res = ''; isunder = False
    for i in range(len(arr)):
        if 'A' <= arr[i] <= 'Z' : return 'Error!'
        else:
            if arr[i] == '_' :
                isunder = True
                continue
            if isunder == True:
                res += arr[i].upper()
                isunder = False
                continue
        res += arr[i]
    return res
def java(arr):
    #java -> cpp
    #_만들고 소문자화
    #첫단어가 대문자면 Error! 출력
    res = ''; isupper = False
    for i in range(len(arr)):
        if 'A' <= arr[i] <= 'Z':
            if i == 0 : return 'Error!'
            else:
                res += '_'+arr[i].lower()
        else : res += arr[i]
    return res

v = input()
if '_' in v : print(cpp(v))
else : print(java(v))