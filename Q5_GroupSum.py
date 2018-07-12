def groupSum(start, arr, target):
    if (target == 0):
        return True
    elif (start >= len(arr)):
        return False

    return (groupSum(start+1, arr, target-arr[start]) or
            groupSum(start+1, arr, target))

#test cases
arr = [2, 4, 8]
print(groupSum(0, arr, 10))
print(groupSum(0, arr, 14))
print(groupSum(0, arr, 9))
print(groupSum(1, arr, 8))
