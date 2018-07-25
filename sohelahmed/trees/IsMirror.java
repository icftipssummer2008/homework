package com.sohel.trees;


public class IsMirror {

		
		Node root1, root2;
		
	
		 public static boolean isMirror(Node root1, Node root2){
			 if(root1 == null && root2 ==null) return true; 
			 if(root1.key == root2.key)
				 return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
			return false;
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsMirror tree = new IsMirror();
		  
	        tree.root1 = new Node(1);
	        tree.root1.left = new Node(2);
	        tree.root1.right = new Node(3);
	      
	  
	        tree.root2 = new Node(1);
	        tree.root2.left = new Node(3);
	        tree.root2.right = new Node(2);
	      
	        if (isMirror(tree.root1, tree.root2))
	            System.out.println("Both trees are Mirror to Each Other");
	        else
	            System.out.println("Trees are not Not Mirror to Each Other");

	}

}


