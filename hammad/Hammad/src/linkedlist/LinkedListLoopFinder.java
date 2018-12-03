package linkedlist;

public class LinkedListLoopFinder {
	public static void main(String[] args) {
		LinkedList linkedList = LinkedListUtil.getUnLoopedLinkedList();
		LinkedList loopedLinkedList = LinkedListUtil.getLoopedLinkedList();
		//System.out.println(detectLoop(loopedLinkedList));
		//System.out.println(detectLoop(loopedLinkedList));
		//LinkedListUtil.traverseLinkedList(linkedList);
		LinkedList loop = getLoop(loopedLinkedList);
		System.out.println(loop.value);
	}
	
	public static boolean detectLoop(LinkedList linkedList) {
		
		if(linkedList == null || linkedList.next == null) {
			return false;
		}
		
		LinkedList slowPointer = linkedList;
		LinkedList fastPointer = linkedList;
		while(fastPointer != null && fastPointer.next != null) {

			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			if(slowPointer.value == fastPointer.value) {
				return true;
			}

		}
		
		return false;
	}
	
	public static LinkedList getLoop(LinkedList linkedList) {
		
		if(linkedList == null || linkedList.next == null) {
			return null;
		}
		
		LinkedList slowPointer = linkedList;
		LinkedList fastPointer = linkedList;
		while(fastPointer != null && fastPointer.next != null) {
			
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			if(slowPointer.value == fastPointer.value) {
				return slowPointer;
			}
			
		}
		
		return null;
	}
}
