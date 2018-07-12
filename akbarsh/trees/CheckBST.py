"""
Is it a BST?
This is a very well known interview problem: Given a Binary Tree, check if it is a Binary Search
Tree (BST). A valid BST doesn't have to be complete or balanced. Duplicate elements are not allowed in a BST.
O(N) time and space.
"""
def inorderbsthelper(root,result):
    if root==None:
        return
    else:
        inorderbsthelper(root.left,result)
        result.append(root.value)
        inorderbsthelper(root.right,result)
    return result

def inorderbst(root):
    result=[]
    return inorderbsthelper(root,result)

def checkbst(root):  # other way is to do inorder traversal and check if list is sorted in increasing order;
    l = inorderbst(root)
    return all(l[i] <= l[i + 1] for i in xrange(len(l) - 1))  # increasing order of sorted list