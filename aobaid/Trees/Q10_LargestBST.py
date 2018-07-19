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

class BST:
    def __init__(self, node, size):
        self.value = size
        self.node = node

def largestBST(node):
    thisBST = BST(node, 0)
    if (thisBST.node): thisNode = thisBST.node.value
    if (node == None):
        thisBST.size = 0
        return thisBST
    if (node.isLeaf()):
        thisBST.size = 1
        return thisBST

    leftBST  = largestBST(node.lChild)
    if (leftBST.node): leftBSTNode = leftBST.node.value
    rightBST = largestBST(node.rChild)
    if (rightBST.node): rightBSTNode = rightBST.node.value

    if (node.lChild == None):
        if (rightBST.node == node.rChild and
            node.value < node.rChild.value):
            thisBST.node = node
            thisBST.size = 1 + rightBST.size
            return thisBST
            
    if (node.rChild == None):
        if (leftBST.node == node.lChild and
            node.value > node.lChild.value):
            thisBST.node = node
            thisBST.size = 1 + leftBST.size
            return thisBST
            
    if (node.lChild and node.rChild and
        leftBST.node == node.lChild and
        rightBST.node == node.rChild and 
        node.value > node.lChild.value and
        node.value < node.rChild.value):
        thisBST.node = node
        thisBST.size = 1 + leftBST.size + rightBST.size
        return thisBST

    if (leftBST.size > rightBST.size):
        return leftBST
    else:
        return rightBST


def inOrder(node, path):
    if (node == None):
        return
    if (node.lChild != None):
        inOrder(node.lChild, path)
    path.append(node.value)
    if (node.rChild != None):
        inOrder(node.rChild, path)

#Test data
#initializing a tree
tree = Node(10)
tree.addLeftChild(20)
node = tree.lChild
node.addLeftChild(2)
node.addRightChild(25)
node = node.rChild
node.addLeftChild(24)
node.lChild.addLeftChild(22)
node.addRightChild(30)
tree.addRightChild(50)
node = tree.rChild
node.addRightChild(80)
node = node.rChild
node.addLeftChild(90)
node.addRightChild(70)


path = []
inOrder(tree, path)
print (path)

lBST = largestBST(tree)
path = []
inOrder(lBST.node, path)
print ("size =", lBST.size)
print (path)
