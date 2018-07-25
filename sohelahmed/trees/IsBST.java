package com.sohel.trees;


public class IsBST {
	
	Node root;
	
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);	
	}
	
	private boolean isBSTUtil(Node root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if(root == null)
			return true;
		
		if(root.key < minValue || root.key > maxValue )
			return false;
		
		return (isBSTUtil(root.left, minValue, root.key-1)) && (isBSTUtil(root.right, root.key+1, maxValue));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsBST tree = new IsBST();
		  
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
      	
	}
}
