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

def reverseTree(node):
    if (node == None):
        return None
    if (node.hasNoChild()):
        return node
    rightChild = node.rChild
    leftChild = node.lChild
    node.lChild = reverseTree(rightChild)
    node.rChild = reverseTree(leftChild)
    return node

#the following function is for debugging purpose only   
def traverseInOrder(node):
    if (node.lChild != None):
        traverseInOrder(node.lChild)
    print (", ",node.value)
    if (node.rChild != None):
        traverseInOrder(node.rChild)

#initializing a tree
tree = Node(1)
tree.addLeftChild(2)
node = tree.lChild
node.addLeftChild(4)
node.addRightChild(5)
tree.addRightChild(3)
node = tree.rChild
node.addLeftChild(6)
node.addRightChild(7)
#checking if the tree created is as intended
traverseInOrder(tree)

tree = reverseTree(tree)
traverseInOrder(tree)
