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
       
def cloneTree(node):
    if (node == None):
        return None

    cloneNode = Node(node.value)
    cloneNode.lChild = cloneTree(node.lChild)
    cloneNode.rChild = cloneTree(node.rChild)
    
    return cloneNode


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


path = []
inOrder(tree, path)
print (path)

clone = cloneTree(tree)
path = []
inOrder(clone, path)
print (path)
