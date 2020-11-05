
def javatoc(text):

    if text[0] >= 'A' and text[0] <= 'Z':
        return "Error!"
    
    x = ""
    for i in text:
        if i >='A' and i <= 'Z':
            x = x + "_"+i.lower()
        else:
            x = x + i

    return x
    


def ctojava(text):
    x = ""
    daum = False
    
    if text[0] == '_' or text[-1]== '_' or '__' in text: #반례들 조심할 것
        return "Error!"
    
    
    for i in text:
        if i >= 'A' and i<='Z':
            return "Error!"

        

        if i == "_":
            daum = True

        else:
            if daum == False:
                x = x + i
            else:
                x = x + i.upper()
                daum = False
                
    return x

text = input()

if '_' in text:
    print(ctojava(text))
else:
    print(javatoc(text))
                

        
