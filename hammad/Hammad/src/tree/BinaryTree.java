package tree;

public class BinaryTree {
	
	Node  root;

	public static void main(String[] args) {
		Node root = getBST();
		
		int diameter = diameter(root);
		System.out.println(diameter);
		
		
	}

	public static Node getBST() {
		BinaryTree bt = new BinaryTree();
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
	 
	    if( Math.random()%2 == 0) {
	        current.left = addRecursive(current.left, value);
	    }
	    else {
	        current.right = addRecursive(current.right, value);
	    }
	 
	    return current;
	}
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private BinaryTree createBinaryTree() {
	    BinaryTree bt = new BinaryTree();
	 
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(1);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	 
	    return bt;
	}

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