#encoding=utf-8

class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

"""
If you are given two traversal sequences, can you construct the binary tree?
Ans: If one of the traversal methods is Inorder then the tree can be constructed, otherwise not.
 But if know that the Binary Tree is Full, we can construct the tree without ambiguity.
Algorithm: buildTree()
1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
2) Create a new tree node tNode with the data as picked element.
3) Find the picked element’s index in Inorder. Let the index be inIndex.
4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
6) return tNode.
"""
def searchidx(inOrder,st,end,value):
    for i in xrange(st,end+1):
        if inOrder[i]==value:
            return i

def buildTree_rec(inOrder, preOrder,st,end):
    if st>end:
        return
    node=Node(preOrder[buildTree.preIndex])
    buildTree.preIndex+=1
    if st==end: #If no child nodes
        return node
    inidx=searchidx(inOrder,st,end,node.value) #find index of node in inOrder
    node.left = buildTree_rec(inOrder, preOrder,st,inidx-1) #for elements before inIndex and make the built tree as left subtree of node
    node.right = buildTree_rec(inOrder, preOrder,inidx+1, end) #for elements after inIndex and make the built tree as right subtree of node
    return node

def printinorder(root):
    if root==None:
        return
    printinorder(root.left)
    print root.value,
    printinorder(root.right)

def buildTree(inOrder, preOrder):
    preidx = st = 0
    end=len(inOrder)-1
    buildTree.preIndex = 0 #static variable
    root= buildTree_rec(inOrder, preOrder,st,end)
    printinorder(root)

inOrder = ['D', 'B' ,'E', 'A', 'F', 'C']
preOrder = ['A', 'B', 'D', 'E', 'C', 'F']
buildTree(inOrder, preOrder)