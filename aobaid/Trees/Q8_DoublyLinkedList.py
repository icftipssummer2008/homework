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
def traverseTree(node, prevNode):
    if (prevNode[0] != None):
        prevVal = prevNode[0].value
        
    if (node.isLeaf()):
        node.lChild = prevNode[0]
        if (prevNode[0] != None):
            prevNode[0].rChild = node
        prevNode[0] = node
        return

    if (node.lChild != None):
        traverseTree(node.lChild, prevNode)

    node.lChild = prevNode[0]
    if (prevNode[0]!= None):
        prevNode[0].rChild = node
    prevNode[0] = node
        
    if (node.rChild != None):
        traverseTree(node.rChild, prevNode)


#Main function as desired required by question
def makeList(node):
    if (node == None):
        return None

    prevNode = [None]
    traverseTree(tree, prevNode)
    node = prevNode[0]
    while (node.lChild != None):
        node = node.lChild
    node.lChild = prevNode[0]
    prevNode[0].rChild = node
    return node
    

def printList(node):
    listNodes = []
    startNode = node
    listNodes.append(node.value)
    nextNode = node.rChild
    while (nextNode != node):
        listNodes.append(nextNode.value)
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

firstNode = makeList(tree)
printList(firstNode)
