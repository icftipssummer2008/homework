#encoding=utf-8
"""
Given a string of integers as input, put between each pair of digits, one of {“”, “*”, “+”} to generate all possible expressions as Strings. Putting an empty string ("") between two numbers means, that the numbers are joined to form a new number
(e.g. 1 "" 2 = 12)

Input:
1. String of positive integers
Output:
All possible strings with operators
e.g.
If the input string is "222",
1. 22+2 (Here, we put the "" operator in between first two 2s and then put a plus between the
last two)
2. 2+22 (Here, we put the plus operator between first two 2s and then put the "" operator
between the last two)
3. 2+2+2
4. 22*2
5. 2*22
6. 2*2*2*
7. 222
"""
opts=['','*','+']
def exprgen(exp):
    res=''
    exprgen_rec(exp,0,res)
def exprgen_rec(exp,idx,res):
    if idx>=len(exp):
        print res
        return
    ch=exp[idx]
    for opt in opts:
        exprgen_rec(exp, idx+1, res+ch+opt)
exprgen("222")