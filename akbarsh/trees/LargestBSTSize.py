"""
Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it.
 The largest BST must include all of its descendants. One way is to do inorder traversal and check for max incr sequence.
 The other way is to check recursively isBST on every node and if true then find size (1+ldepth+rdepth).
"""
class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def inorderbsthelper(root,result):
    if root==None:
        return
    else:
        inorderbsthelper(root.left,result)
        result.append(root.value)
        inorderbsthelper(root.right,result)
    return result

def inorderbst( root):
    result=[]
    return inorderbsthelper(root,result)

def largestBSTSize(root):
    lst= inorderbst( root)
    currcnt=maxcnt=0
    for i in xrange(len(lst)-1):
        if lst[i]<lst[i+1]:
            currcnt+=1
            if maxcnt<currcnt:
                maxcnt=currcnt
        else:
            currcnt=0
    return maxcnt+1

root7 = Node(10)
root7.left = Node(15)
root7.right = Node(1)
root7.left.left = Node(7)
root7.left.right = Node(16)
root7.right.left = Node(9)
root7.right.right = Node(14)

print largestBSTSize(root7)