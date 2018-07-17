#encoding=utf-8
"""
Least Common Ancestor (LCA)
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined
as the lowest node in T that has both n1 and n2 as descendants.
The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the
root. Computation of lowest common ancestors may be useful, for instance, as part of a
procedure for determining the distance between pairs of nodes in a tree: the distance from n1
to n2 can be computed as the distance from the root to n1, plus the distance from the root to
n2, minus twice the distance from the root to their lowest common ancestor.

The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root,
then root is LCA (assuming that both values are present). If root doesn’t match with any of the keys, we recur for left and right subtree.
The node which has one value present in its left subtree and the other key present in right subtree is the LCA.
If both keys lie in left subtree, then left subtree has LCA, otherwise LCA lies in right subtree.
"""
class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None
def findLCA(root,n1,n2):
    if root==None:
        return
    elif root.value==n1 or root.value==n2: #if root values matches one of n1 or n2 then its LCA
        return root
    elif findLCA(root.left,n1,n2) and findLCA(root.right,n1,n2): #if one value lies in left subtree and other in right subtree then root is LCA
        return root
    else:
        return findLCA(root.left,n1,n2) or findLCA(root.right,n1,n2) #else LCA lies in left subtree or right subtree

root2 = Node(1)
root2.left = Node(2)
root2.right = Node(3)
root2.left.left = Node(4)
root2.left.right = Node(5)
root2.right.left = Node(6)
root2.right.right = Node(7)
print "LCA(4,5) = ", findLCA(root2, 4, 5).value
print "LCA(4,6) = ", findLCA(root2, 4, 6).value
print "LCA(3,4) = ", findLCA(root2, 3, 4).value
print "LCA(2,4) = ", findLCA(root2, 2, 4).value