package com.sohel.trees;
	
	class Node {
	    int key;
	    Node left, right;
	
	    public Node(int item) {
	        key = item;
	        left = right = null;
	    }
	}

	public class IdentialBSTs {
		
		Node root1, root2;
		
	
		 public static boolean isIdentical(Node root1, Node root2){
			 if(root1 == null && root2 ==null) return true; 
			 if(root1.key == root2.key)
				 return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
			return false;
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentialBSTs tree = new IdentialBSTs();
		  
	        tree.root1 = new Node(1);
	        tree.root1.left = new Node(2);
	        tree.root1.right = new Node(3);
	        tree.root1.left.left = new Node(4);
	        tree.root1.left.right = new Node(5);
	  
	        tree.root2 = new Node(1);
	        tree.root2.left = new Node(2);
	        tree.root2.right = new Node(3);
	        tree.root2.left.left = new Node(4);
	        tree.root2.left.right = new Node(5);
	  
	        if (isIdentical(tree.root1, tree.root2))
	            System.out.println("Both trees are identical");
	        else
	            System.out.println("Trees are not identical");

	}

}
