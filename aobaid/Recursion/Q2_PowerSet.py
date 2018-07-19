# Powerset using recursion

def printPowerSet (superList):
    output = list()
    for c in superList:
        output.append("")
    printSets(superList, output, 0, 0, 0)


def printSets(lst, output, indxR, indxW, lvl):
    if (indxR == len(lst)):
        print (output[0:indxW])
        return
    printSets(lst, output, indxR+1, indxW, lvl+1)
    output[indxW] = lst[indxR]
    printSets(lst, output, indxR+1, indxW+1, lvl+1)

printPowerSet(['a', 'b', 'c'])
