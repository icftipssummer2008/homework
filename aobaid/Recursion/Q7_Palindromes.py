#backtracking problem
#find a valid palindrome and then find all subsequent palindromes (store this completed set)
#find the next valid palindrome and the find all subsequent palindromes (store this completed set too)
#keep finding larger valid palindromes until you reach the end of the string (then output all completed sets)

def addPalindrome(s, start, partition):
    slen = len(s)
    if (start == slen):
        print(partition)

    for i in range(start+1, slen+1):
        substr = s[start:i]
        if isPalindrome(substr):
            partition.append(substr)
            addPalindrome(s, i, partition)
            tempStr = partition.pop()

def isPalindrome(s):
    slen = len(s)
    if (slen <= 1): return True
    if (s[0] == s[slen-1]):
        return isPalindrome(s[1:slen-1])
    else:
        return False

def printPalindromes(s):
    partition = []
    addPalindrome(s, 0, partition)


printPalindromes("abracacacbra")
