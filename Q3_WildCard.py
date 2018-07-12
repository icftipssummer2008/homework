#will use recursion

def printWildCard(s):
    result = ""
    printWord(s, result, 0)
    
def printWord(s, result, i):
    if (i == len(s)):
        print (result)
        return
    if (s[i] == "?"):
        printWord(s, result+'0', i+1)
        printWord(s, result+'1', i+1)
    else:
        printWord(s, result+s[i], i+1)

printWildCard("?0?1") 
