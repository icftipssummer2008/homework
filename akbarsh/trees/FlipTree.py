class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def flip(root): #also called mirror or inverted tree
    if root==None:
        return
    root.left,root.right=root.right,root.left
    flip(root.left)
    flip(root.right)

root4 = Node(1)
root4.left = Node(2)
root4.right = Node(3)
root4.left.left = Node(4)
root4.left.right = Node(5)
root4.right.left = Node(6)
root4.right.right = Node(7)

flip(root4)
print root4.value
print root4.left.value
print root4.right.value
print root4.left.left.value
print root4.left.right.value
print root4.right.left.value
print root4.right.right.value