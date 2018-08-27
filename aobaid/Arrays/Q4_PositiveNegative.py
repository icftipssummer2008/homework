def positiveNegative(arr):
    for i in range(len(arr)):
        j = 0
        while (j+2 < len(arr)):
            if (sign(arr[j]) == sign(arr[j+1]) and
                not (sign(arr[j+1]) == sign(arr[j+2]))):
                arr[j+1], arr[j+2] = arr[j+2], arr[j+1]
            j += 1
    
def sign(n):
    return (n >= 0)

	
arr = [1,2,3,4,5,6,-1,-2,-3,-4,-5,-6,-7,8]
positiveNegative(arr)
print(arr)

    
