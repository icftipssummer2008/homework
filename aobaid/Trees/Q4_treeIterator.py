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

class TreeIt:
    nextNode = Node(None)
    parents = []
    
    def iterator(root):
        TreeIt.nextNode = root
        if (root == None):
            return
        while (TreeIt.nextNode.lChild):
            TreeIt.parents.append(TreeIt.nextNode)
            TreeIt.nextNode = TreeIt.nextNode.lChild
        pass

    def hasNext():
        return (TreeIt.nextNode)

    def next():
        if (not TreeIt.hasNext()):
            raise StopIteration ("No more nodes")
        r = TreeIt.nextNode

        if (TreeIt.nextNode.rChild):
            TreeIt.parents.append(TreeIt.nextNode)
            TreeIt.nextNode = TreeIt.nextNode.rChild
            while (TreeIt.nextNode.lChild):
                TreeIt.parents.append(TreeIt.nextNode)
                TreeIt.nextNode = TreeIt.nextNode.lChild
            return r

        while (True):
            if (not len(TreeIt.parents)):
                TreeIt.nextNode = None
                return r
            prnt = TreeIt.parents.pop()
            TreeIt.parents.append(prnt)
            if (prnt.rChild == TreeIt.nextNode):
                TreeIt.nextNode = prnt
                prnt = TreeIt.parents.pop()
                continue
            else:
                TreeIt.nextNode = prnt
                prnt = TreeIt.parents.pop()
                return r


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
node.addLeftChild('D')
node.addRightChild('C')
tree.addRightChild('E')
node = tree.rChild
node.addRightChild('G')
node.rChild.addRightChild('I')
node.addLeftChild('F')
node.lChild.addLeftChild('H')


path = []
inOrder(tree, path)
print (path)

path = []
it = TreeIt
it.iterator(tree)
while (it.hasNext()):
    path.append(it.next().value)
print (path)
