package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeTree {
	public static void main(String[] args) {
		Node root1 = BinarySearchTree.getBST();
		Node root2 = BinarySearchTree.getBST();
		
		List<Integer> list = merge(root1, root2);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}
	
	public static List<Integer> merge(Node root1, Node root2) {
		Queue<Integer> bst1 = toQueue(root1);
		Queue<Integer> bst2 = toQueue(root2);
		return merge(bst1, bst2);
	}

	public static List<Integer> merge(Queue<Integer> bst1, Queue<Integer> bst2) {
		List<Integer> outputBst = new ArrayList<>();
		merge(bst1, bst2, outputBst, 0, 0);
		return outputBst;
	}

	public static void merge(Queue<Integer> bst1, Queue<Integer> bst2, List<Integer> outputBst, int i1, int i2) {
		if(bst1.isEmpty() && bst2.isEmpty()) {
			return;
		}
		
		if(bst1.peek() == null) {
			outputBst.add(bst2.poll());
		}
		
		else if(bst2.peek() == null) {
			outputBst.add(bst1.poll());
		}
		
		else if(bst1.peek() < bst2.peek()) {
			outputBst.add(bst1.poll());
		}
		else {
			outputBst.add(bst2.poll());
		}
		
		merge(bst1, bst2, outputBst, i1, i2);
	}
	
	public static Queue<Integer> toQueue(Node root) {
		Queue<Integer> q = new LinkedList<>();
		toQueue(root, q);
		return q;
	}
	
	public static void toQueue(Node current, Queue<Integer> q) {
		if(current == null) {
			return;
		}
		toQueue(current.left, q);
		q.add(current.value);
		toQueue(current.right, q);
	}
}
