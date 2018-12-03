package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtil {
	
	public static LinkedList getLoopedLinkedList() {
		LinkedList node = new LinkedList(5);
		
		LinkedList node1 = new LinkedList(6);
		node.next = node1;
		
		LinkedList node2 = new LinkedList(9);
		node1.next = node2;
		
		LinkedList node3 = new LinkedList(91);
		node2.next = node3;
		
		LinkedList node4 = new LinkedList(102);
		node3.next = node4;
		
		LinkedList node5 = new LinkedList(101);
		node4.next = node5;
		
		LinkedList node6 = new LinkedList(89);
		node5.next = node6;
		
		node5.next = node1;
		
		
		return node;

	}

	public static LinkedList getUnLoopedLinkedList() {
		LinkedList node = new LinkedList(5);
		
		LinkedList node1 = new LinkedList(6);
		node.next = node1;
		
		LinkedList node2 = new LinkedList(9);
		node1.next = node2;
		
		LinkedList node3 = new LinkedList(91);
		node2.next = node3;
		
		LinkedList node4 = new LinkedList(102);
		node3.next = node4;
				
		
		return node;
		
	}
	
	public static List<Integer> traverseLinkedList(LinkedList node) {
		List<Integer> list = new ArrayList<>();
		LinkedList temp = node;
		while(temp != null) {
			list.add(temp.value);
			temp = node.next;
		}
		
		return list;
	}
}
