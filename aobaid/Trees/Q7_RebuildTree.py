class Node:
    def __init__(self, value):
        self.value = value
        self.lChild = None
        self.rChild = None
    def hasNoChild(self):
        return (self.lChild == None and self.rChild == None)
    def addLeftChild(self, value):
        node = Node(value)
        self.lChild = node
    def addRightChild(self, value):
        node = Node(value)
        self.rChild = node
        
def buildTreeMain(preOrder, inOrder):
    preLen = len(preOrder)
    inLen = len(inOrder)
    if (len(preOrder) == 0):
        return None
    return buildTree(preOrder, 0, preLen-1, InOrder, 0, inLen-1)

def buildTree(preOrder, preStart, preEnd, inOrder, inStart, inEnd):
    #end-condition: no more values left to traverse
    if (inStart > inEnd):
        return None

    #find position of root node in InOrder list
    rootval = preOrder[preStart]
    rootIndex = inStart
    for i in range(inStart, inEnd+1):
        if (inOrder[i] == rootval):
            rootIndex = i
            break

    leftLen = rootIndex - inStart
    root = Node(rootval)
    root.lChild = buildTree(preOrder, preStart+1, preStart+leftLen, inOrder, inStart, rootIndex-1)
    root.rChild = buildTree(preOrder, preStart+1+leftLen, preEnd, inOrder, rootIndex+1, inEnd)
    return root

#Traverse a tree PostOrder with recursion
def traversePostOrder(node, result):
    if (node == None):
        return;
    if (node.lChild != None):
        traversePostOrder(node.lChild, result)
    if (node.rChild != None):
        traversePostOrder(node.rChild, result)
    result.append(node.value)

    
preOrder = ['A', 'B', 'D', 'C', 'E', 'F', 'G']
InOrder = ['D', 'B', 'A', 'E', 'C', 'F', 'G']

bTree = buildTreeMain(preOrder, InOrder)

result = []
traversePostOrder(bTree, result)
print("Post Order: ", result)





    
   
