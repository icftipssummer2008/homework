package tree;

public class BinarySearchTree {
	
	final int[] treeArray = {1,2,3,4,5,6,7};
	
	Node  root;

	public static void main(String[] args) {
		Node root = getBST();
		
		int diameter = diameter(root);
		System.out.println(diameter);
		
		
	}

	public static Node getBST() {
		BinarySearchTree bt = new BinarySearchTree();
		bt = bt.createBinaryTree();
		Node root = bt.root;
		return root;
	}
	
	private static int diameter(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int leftDiamter = diameter(root.left);
		int rightDiamter = diameter(root.right);
		
		int totalHeight = leftHeight +  rightHeight;
		int maxDiamter = Math.max(leftDiamter, rightDiamter);
		
		return Math.max(totalHeight, maxDiamter) ;
		
	}
	
	private static int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
	
	private  Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private BinarySearchTree createBinaryTree() {
	    BinarySearchTree bt = new BinarySearchTree();
	 
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    bt.add(1);
	 
	    return bt;
	}
	
	private BinarySearchTree createBinaryTree1() {
	    BinarySearchTree bt = new BinarySearchTree();
	 
	    for (int n : treeArray) {
	    	bt.add(n);
		}
	 
	    return bt;
	}

}

class Count {
	
	public Count(int value) {
		super();
		this.value = value;
	}

	int value;
}

class Node {
	
	public Node(int value) {
		super();
		this.value = value;
	}
	Node left;
	Node right;
	int value;
}

/*
 * 
Partition Equal Subset Sum

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1: Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].

 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 * 
*/