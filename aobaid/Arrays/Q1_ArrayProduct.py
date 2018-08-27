def prodArray(arr):
    if (arr == []):
        return []

    outArr = [0 for i in range(len(arr))]

    product = 1
    for i in range(len(arr)):
        outArr[i] = product
        product = product * arr[i]

    product = 1
    for i in range(len(arr)-1, -1, -1):
        outArr[i] = product * outArr[i]
        product = product * arr[i]

    return outArr

arr = [1, 2, 3, 4, 5]
out = prodArray(arr)

print (out)

