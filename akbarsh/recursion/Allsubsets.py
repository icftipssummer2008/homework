#combinations(subsets) 2^n*O(n) is time complexity and O(n) space(each for call stack and calls)
#Tail recursion
def combinations(l):
    if l == []:
       return [[]]
    return combinations(l[1:]) + [[l[0]] + c for c in combinations(l[1:])] #starting with [], ['c'] and then every char as l[0] gets added to these along with these
print combinations(['a','b','c'])