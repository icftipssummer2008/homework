#define Node class (not adding other functions as they are not needed for this question)
class Node:
    def __init__(self, value):
        self.value = value
        self.lChild = None
        self.rChild = None
    def isLeaf(self):
        return (self.lChild == None and self.rChild == None)
    def addLeftChild(self, value):
        node = Node(value)
        self.lChild = node
    def addRightChild(self, value):
        node = Node(value)
        self.rChild = node

#Helper function
def treeToList(node):       #returns header node of generated list
    if (node == None):
        return None

##    nodeVal = node.value
##    if (node.lChild): leftChild = node.lChild.value
##    if (node.rChild): rightChild = node.rChild.value
    
    leftList = treeToList(node.lChild)
##    if (leftList): lListFirst = leftList.value
##    if (leftList): lListLast = leftList.lChild.value
##    pass
    rightList = treeToList(node.rChild)
##    if (rightList): rListFirst = rightList.value
##    if (rightList): rListLast = rightList.lChild.value
##    pass

    node.lChild = node
    node.rChild = node

    leftList = appendList(leftList, node)
##    if (leftList): lListFirst = leftList.value
##    if (leftList): lListLast = leftList.lChild.value
##    pass
    leftList = appendList(leftList, rightList)
##    if (leftList): lListFirst = leftList.value
##    if (leftList): lListLast = leftList.lChild.value
##    pass

    return leftList
        
def appendList(a, b):
    if (a == None): return b
    if (b == None): return a
    aLast = a.lChild
    bLast = b.lChild
    a.lChild = bLast
    bLast.rChild = a
    aLast.rChild = b
    b.lChild = aLast
    return a


def printList(node):
    if (node == None):
        return
    nextNode = node
    lastNode = node.lChild
    listNodes = []
    while (True):
        listNodes.append(nextNode.value)
        if (nextNode == lastNode):
            break
        else:
            nextNode = nextNode.rChild
    print (listNodes)

#Test data
#initializing a tree
tree = Node('A')
tree.addLeftChild('B')
node = tree.lChild
node.addLeftChild('C')
node.addRightChild('D')
node = node.rChild
node.addLeftChild('E')
node.addRightChild('F')
tree.addRightChild('G')
node = tree.rChild
node.addRightChild('H')
node = node.rChild
node.addLeftChild('J')
node.addRightChild('I')

firstNode = treeToList(tree)
printList(firstNode)
