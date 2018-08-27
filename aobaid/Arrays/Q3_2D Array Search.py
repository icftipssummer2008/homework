def targetNumberExists(arr, N, M, target):

    #start from top-right corner
    row = 0
    col = M - 1
		
    while(row < N and col < M):
        if (arr[row][col] == target):
            return True
        elif (arr[row][col] > target):
            col -= 1
        else:
            row += 1
        
    return False
	
arr = []
arr.append([1,8,16,24,32])
arr.append([2,10,18,26,34])
arr.append([4,12,20,28,36])
arr.append([8,16,24,32,40])
nExists = targetNumberExists(arr, 4, 5, 21)

print("nExists =",nExists)

    
