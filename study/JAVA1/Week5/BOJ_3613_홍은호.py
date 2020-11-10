def CtoJava(test):
    result = ""
    flag = False

    if test[0] == "_" or test[-1] == "_" or "__" in test:
        result = "Error!"
        return result

    for i in test:
        if 65<= ord(i) <= 90:
            result = "Error!"
            return result

        if i == "_":
            flag = True
            continue

        if flag == True:
            result += i.upper()
            flag = False
            continue
        result += i

    return result

def JavatoC(test):
    result = ""

    if 65<=ord(test[0])<=90:
        result = "Error!"
        return result

    for i in test:
        if 65<=ord(i)<=90:
            result += "_"+i.lower()
        else:
            result += i

    return result


test = input()

if "_" in test:
    print(CtoJava(test))

else:
    print(JavatoC(test))