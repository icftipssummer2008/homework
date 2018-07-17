# encoding=utf-8
"""
Given a binary tree, print out all of its root-to-leaf paths one per line.
"""
class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def printPath(root):
    path = [0] * 10
    pl = 0
    printpaths(root, path, pl)

def printpaths(root, path, pl):
    if root == None:
        return
    path[pl] = root.value
    pl += 1
    if root.left == None and root.right == None:
        printp(path, pl)
    else:
        printpaths(root.left, path, pl)
        printpaths(root.right, path, pl)

def printp(path, pl):
    for i in xrange(pl):
        print path[i],
    print "\n"

root3 = Node(1)
root3.left = Node(2)
root3.right = Node(3)
root3.left.left = Node(4)
root3.left.right = Node(5)
printPath(root3)