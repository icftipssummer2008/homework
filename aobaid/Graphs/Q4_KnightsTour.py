class Node:
    def __init__(self, row, col, steps=0):
        self.row = row
        self.col = col
        self.steps = steps

def knightMoves (rows, cols, startX, startY, endX, endY):
    if (startX == endX and startY == endY):
        return 0

    rowArr = [-2, -2, -1, -1, +1, +1, +2, +2]
    colArr = [-1, +1, -2, +2, -2, +2, -1, +1]
    
    isVisited = []
    q = []
    node = Node(startX, startY, 0)
    q.append(node)
    cellNum = (startX * cols) + startY
    isVisited.append(cellNum)
    


    while (q):
        node = q.pop(0)
        
        for i in range(0,8):
            nextRow = node.row + rowArr[i]
            nextCol = node.col + colArr[i]
            if (nextRow == endX and nextCol == endY):
                return node.steps + 1
            if (nextRow < 0 or nextRow >= rows or
                nextCol < 0 or nextCol >= cols):
                continue
            cellNum = (nextRow * cols) + nextCol
            if (cellNum in isVisited):
                continue
            isVisited.append(cellNum)
            thisNode = Node(nextRow, nextCol, node.steps + 1)
            q.append(thisNode)
    else:
        return -1


moves = knightMoves(8, 8, 0, 0, 7, 7)
print ("Number of moves needed =", moves)

        

