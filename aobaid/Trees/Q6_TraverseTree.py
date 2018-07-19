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
        
#Traverse a tree PostOrder with recursion
def traversePostOrder(node, result):
    if (node == None):
        return;
    if (node.lChild != None):
        traversePostOrder(node.lChild, result)
    if (node.rChild != None):
        traversePostOrder(node.rChild, result)
    result.append(node.value)

#Traverse a tree PostOrder without recursion
def traversePostOrder1(node, result):
    if (node == None):
        return;
    stack = []
    stack.append(node)
    while (stack != []):
        node = stack.pop()
        result.append(node.value)
        if (node.lChild != None):
            stack.append(node.lChild)
        if (node.rChild != None):
            stack.append(node.rChild)

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
result = []
traversePostOrder(tree, result)
print("With recursion: ", result)

result = []
traversePostOrder1(tree, result)
tmp = []
for i in range(len(result)):
    tmp.append(result.pop())
print("Without recursion: ", tmp)
