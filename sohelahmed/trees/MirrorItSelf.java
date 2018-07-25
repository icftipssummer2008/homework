package com.sohel.trees;


public class MirrorItSelf {
			
	Node root;
			
		
	 public static boolean isMirror(Node root){
		 if ((root == null) || ((root != null) && (root.left == null && root.right == null))) return true; 
		 
		 if ((root.left != null || root.right != null) && (root.left.key == root.right.key))
			 return isMirror(root.left) && isMirror(root.right);
		return false;
	 }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MirrorItSelf tree = new MirrorItSelf();
			  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(4);

        
		if (isMirror(tree.root))
			System.out.println("Tree is Symmetrical");
	    else
	    	System.out.println("Trees is not Not Symmetrical");

		}

	}
