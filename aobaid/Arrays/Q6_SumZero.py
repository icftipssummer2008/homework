def sumZero(intArr):
    dict1 = {}
    runningSum = 0
    outArr = []
    for i in range(len(intArr)):
        if (intArr[i] == 0):
            return [0]
        runningSum += intArr[i]
        if (runningSum in dict1):
            for j in range(dict1[runningSum]+1, i+1):
                outArr.append(intArr[j])
            return outArr
        else:
            dict1[runningSum] = i
    return []

	
intArr = [5,-3,2,-3,7,-4]
outArr = sumZero(intArr)
print(outArr)

    
