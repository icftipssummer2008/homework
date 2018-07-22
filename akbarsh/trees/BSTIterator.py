class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

"""
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
root node of a BST.
1. Calling next() will return the next smallest number in the BST.
2. Calling hasNext() should return whether the next element exists.
Both functions should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
I use Stack to store directed left children from root.
When next() be called, I just pop one element and process its right child as new root.
So this can satisfy O(h) memory, hasNext() in O(1) time. But next() is O(h) time.
"""
class BSTIterator:
    def __init__(self,root):
        self.stack=list()
        self.pushAll(root)
    def pushAll(self,root):
        while root:
            self.stack.append(root)
            root=root.left
    def hasnext(self):
        return self.stack
    def next(self):
        tmp=self.stack.pop()
        self.pushAll(tmp.right)
        return tmp.value

root13 = Node(15)
root13.left = Node(10)
root13.right = Node(18)
root13.left.left = Node(8)
root13.left.right = Node(12)
root13.right.left = Node(17)
root13.right.right = Node(19)
bst = BSTIterator(root13)
print bst.next()
print bst.next()