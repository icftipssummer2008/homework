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

#Will perform Pre-Order traversal
def LCA(tree, val1, val2):
    path1, path2 = [], []
    if (findPath(tree, val1, path1) and
        findPath(tree, val2, path2)):
        return findLCA(path1, path2)
    else:
        return None
    
def findPath(node, val, path):
    path.append(node.value)
    if (node.value == val):
        return True
    if (node.lChild != None and
        findPath(node.lChild, val, path)):
        return True
    elif (node.rChild != None and
        findPath(node.rChild, val, path)):
        return True
    else:
        tmpVal = path.pop()
        return False

def findLCA(path1, path2):
    nodeVal = None
    for i in range(len(path1)):
        if (i < len(path2) and
            path1[i] == path2[i]):
            nodeVal = path1[i]
    return nodeVal
            

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
#traverseInOrder(tree)

val1 = 5
val2 = 6
lcaVal = LCA(tree, val1, val2)
if (lcaVal):
    print ("LCA of ", val1, " and ", val2, " is ", lcaVal)
else:
    print ("There is no LCA between ", val1, " and ", val2)
