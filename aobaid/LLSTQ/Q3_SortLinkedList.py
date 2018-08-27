class ListNode:
    def __init__(self, value):
        self.value = value
        self.nxt = None

def sortList(head):
    if (head == None or head.nxt == None):
        return head

    slow = head
    fast = head
    prev = head
    
    while (not (fast == None or fast.nxt == None)):
        prev = slow
        slow = slow.nxt
        fast = fast.nxt.nxt

    prev.nxt = None

    list1 = sortList(head)
    list2 = sortList(slow)

    list3 = mergeLists(list1, list2)
    return list3

def mergeLists(list1, list2):
    p = ListNode(None)
    thisList = p
    while (list1 and list2):
        if (list1.value < list2.value):
            p.nxt = list1
            list1 = list1.nxt
        else:
            p.nxt = list2
            list2 = list2.nxt
        p = p.nxt
    if (list1):
        p.nxt = list1
    if (list2):
        p.nxt = list2
    return thisList.nxt

def printList(head):
    printArr = []
    node = head
    while (node):
        printArr.append(node.value)
        node = node.nxt
    print (printArr)

list1 = ListNode(4)
node1 = ListNode(2)
list1.nxt = node1
node2 = ListNode(1)
node1.nxt = node2
node1 = node2
node2 = ListNode(3)
node1.nxt = node2

printList(list1)
list1 = sortList(list1)
printList(list1)


list1 = ListNode(-1)
node1 = ListNode(5)
list1.nxt = node1
node2 = ListNode(3)
node1.nxt = node2
node1 = node2
node2 = ListNode(4)
node1.nxt = node2
node1 = node2
node2 = ListNode(0)
node1.nxt = node2

printList(list1)
list1 = sortList(list1)
printList(list1)
