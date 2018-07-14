#similar to wildcard problem
#loop for all possible operator values and keep inserting 

def expGenerator(s):
    result = ""
    printExpr(s, result, 0)

def printExpr(s, result, i):
    oper = ["", "-", "+", "*"]
    if (i == len(s)):
        print(result)
        return
    if (i == 0):  #first character 
        printExpr(s, s[0], 1)
        return
    for char in oper:
        printExpr(s, result+char+s[i], i+1)


#test cases
expGenerator("234")












