def tryOptions(startN, lastN):
    for n in range(startN, lastN+1):
        if putNQueens(n):
            continue
        else:
            print()
            print("Not possible to place ",n," queens on a ",n,"x",n," board")

def putNQueens(n):
    isPossible = False
    for col in range(n):   #find a possible comination for each row
        board = [[0 for j in range(n)] for i in range(n)]
        if placeQueens(0, col, board, n): #check if n queens can be placed starting from row
            print()
            print (n,"x",n," board results below")
            printBoard(board);
            isPossible = True;
    return isPossible

def placeQueens(row, col, board, i):
    if (i == 0):
        return True
    if (col >= len(board[0]) or row >= len(board[0])): #not possible, hence recurse back
        return False
    if isSafe(row, col, board):
        board[row][col] = 1
        if (placeQueens(row+1, 0, board, i-1)):
            return True
        else:
            board[row][col] = 0
            return False
    else:
        return placeQueens(row, col+1, board, i)
            

def isSafe(row, col, board):
    for i in range(row+1):
        for j in range(len(board[0])):
            if ((board[i][j] == 1) and
                ((row == i) or (col == j) or (abs(i-row) == abs(j-col)))):
                   return False
    return True

def printBoard(board):
    size = len(board)
    outStr = "+"
    for i in range(size):
        outStr = outStr + "-+" #first line
    print (outStr)
    for row in range(size):
        outStr1 = ""
        for col in range(size):
            if (board[row][col]):
                outStr1 = outStr1 + "|X"
            else:
                outStr1 = outStr1 + "| "
        outStr1 = outStr1 + "|"
        print (outStr1)
        print (outStr)

tryOptions(4,20)
