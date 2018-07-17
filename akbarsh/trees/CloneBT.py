"""
Given a binary tree (represented by its root node, like usual), clone it. Return the root node of the cloned tree.
This question is more about figuring out the right traversal algorithm. Think how pre-order traversal works.
We first visit the parent and then it's children. So pre-order traversal is the best way to achieve this.
"""
class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def cloneBT(root):
    if root==None:
        return
    clone=Node(root.value)
    clone.left = cloneBT(root.left)
    clone.right = cloneBT(root.right)
    return clone

root5 = Node(1)
root5.left = Node(2)
root5.right = Node(3)
root5.left.left = Node(4)
root5.left.right = Node(5)

print cloneBT(root5).value
print cloneBT(root5).left.value
print cloneBT(root5).right.value
print cloneBT(root5).left.left.value
print cloneBT(root5).left.right.value