"""
Input: 10?
Output: 101, 100
i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with
either 0 or 1.
Input: 1?0?
Output: 1000, 1001, 1100, 1101
Please write a program that takes given strings as input and produces the suggested output.
"""
def wildcard(str):
    st=0
    str=list(str)
    return wildcard_helper(str,st)
def wildcard_helper(str,st):
    if st>=len(str):
        print ''.join(str)
        return
    elif str[st]=='?':
        str[st]='0'
        wildcard_helper(str,st+1)
        str[st] = '1'
        wildcard_helper(str, st + 1)
        str[st]='?' #we need to backtack as string is passed by ref
    else:
        wildcard_helper(str, st + 1)
wildcard('10?')
wildcard('10??1')