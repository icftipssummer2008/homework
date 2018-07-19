class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
"""
Write a recursive function treeToList(Node root) that takes an ordered binary tree and rearranges the internal pointers to make a circular doubly linked list out of the tree nodes. 
The "previous" pointers should be stored in the "small" field and the "next" pointers should be stored in the "large" field. 
The list should be arranged so that the nodes are in increasing order. Return the head pointer to the new list. The operation can be done in O(n) time -- essentially operating on each node once.
The recursion will go down the tree, recursively changing the small and large sub-trees into lists, and then append those lists together with the parent node to make larger lists. 
Separate out a utility function append(Node a, Node b) that takes two circular doubly linked lists and appends them together to make one list which is returned.
"""

"""
helper function -- given two list nodes, join them together so the second immediately follow the first.
Sets the .next of the first and the .previous of the second.
"""
def join(a,b):
    a.right=b #a.next=b
    b.left=a  #b.prev=a

#helper function -- given two circular doubly linkedlists, append them and return the new list.
def append(a,b):
    #if either is null, return the other
    if a==None:
        return b
    if b==None:
        return a
    #find the last node in each using the .previous pointer
    alast = a.left
    blast = b.left
    #join the two together to make it connected and circular
    join(alast,b)
    join(blast,a)
    return a
"""
Given an ordered binary tree(BST), recursively change it into a circular doubly linked list which is returned.
"""
def treeToList(root):
    if root==None:
        return
    #Recursively do the subtrees (leap of faith!)
    alist=treeToList(root.left)
    blist=treeToList(root.right)
    #Make the single root node into a list of length-1 in preparation for the appending
    root.left=root
    root.right=root
    #At this point we have three lists, and it's just a matter of appending them together in the right order (aList, root, bList)/
    alist = append(alist, root)
    alist = append(alist, blist)
    return alist

def printList(head):
    current = head
    while current:
        print current.value,
        current = current.right
        if current==head:
            break

root8 = Node(15)
root8.left = Node(10)
root8.right = Node(18)
root8.left.left = Node(8)
root8.left.right = Node(12)
root8.right.left = Node(17)
root8.right.right = Node(19)

head=treeToList(root8)
printList(head)