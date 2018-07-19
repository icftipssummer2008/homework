class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

"""
Iterative Postorder Traversal
1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack
#Pop Stack2 L R
"""

def iterativePostorder(root):
    if root==None:
        return
    s1=[root]
    s2=[]
    while s1:
        node=s1.pop()
        s2.append(node)
        if node.left:
            s1.append(node.left)
        if node.right:
            s1.append(node.right)
    while s2:
        node = s2.pop()
        print node.value,

root6 = Node(10)
root6.left = Node(8)
root6.right = Node(2)
root6.left.left = Node(3)
root6.left.right = Node(5)
root6.right.left = Node(2)

iterativePostorder(root6) #3 5 8 2 2 10