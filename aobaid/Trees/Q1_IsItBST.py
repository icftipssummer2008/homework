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

#assume In-Order traversal
def isBST(node):
    if (node.lChild != None):
        if (node.value > node.lChild.value and
            isBST(node.lChild)):
            #print("vale=",node.value,", lChild=",node.lChild.value)
            pass
        else:
            #print("vale=",node.value,", lChild=",node.lChild.value)
            return False
    if (node.rChild != None):
        if (node.value < node.rChild.value and
            isBST(node.rChild)):
            #print("vale=",node.value,", rChild=",node.rChild.value)
            pass
        else:
            #print("vale=",node.value,", rChild=",node.rChild.value)
            return False
    return True

#the following function is for debugging purpose only
def traverseInOrder(node):
    if (node.lChild != None):
        traverseInOrder(node.lChild)
    print (", ",node.value)
    if (node.rChild != None):
        traverseInOrder(node.rChild)

#initializing a tree
tree = Node(7)
tree.addLeftChild(3)
node = tree.lChild
node.addLeftChild(1)
node.addRightChild(5)
tree.addRightChild(13)
node = tree.rChild
node.addRightChild(15)
node.addLeftChild(9)
node = node.lChild
node.addRightChild(11)
#checking if the tree created is as intended
traverseInOrder(tree)

result = isBST(tree)
if (result):
    print ("It is a BST")
else:
    print ("It is not a BST")

