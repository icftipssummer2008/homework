def bringLettersToLeft(strArr):
    readP = 0  #read pointer
    writeP = 0

    while (readP < len(strArr) and writeP < len(strArr)):
        if (isNumber(strArr[writeP])):
            if (not isNumber(strArr[readP])):
                strArr[readP], strArr[writeP] = strArr[writeP], strArr[readP]
                readP += 1
                writeP += 1
            else:
                readP += 1
        else:
            writeP += 1
    
def isNumber(n):
    return (n >= '0' and n <= '9')


	
strArr = ['0','a','1','9','3','z','b','r','6','p']
bringLettersToLeft(strArr)
print(strArr)

    
