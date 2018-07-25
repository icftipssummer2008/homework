package com.sohel.trees;

import java.util.ArrayList;

public class KthLargest {
	Node root;
	static ArrayList<Integer> result = new ArrayList<>();
	 
	void printInorder(Node node)
	    {
	        if (node == null)
	            return;
	 
	        /* first recur on left child */
	        printInorder(node.left);
	 
	        /* then print the data of node */
	        System.out.print(node.key + " ");
	        result.add(node.key);
	 
	        /* now recur on right child */
	        printInorder(node.right);
	       
	    }
	    void printInorder()    {     printInorder(root);   }

	 public static void main(String[] args)
	    {
	        KthLargest tree = new KthLargest();
	        tree.root = new Node(4);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(6);
	        tree.root.left.left = new Node(1);
	        tree.root.left.right = new Node(3);
	 
	       
	        System.out.println("\nInorder traversal of binary tree is ");
	        tree.printInorder();
	        
	        // 2nd largest element is
	        int size = result.size();
	        System.out.println("\nSecond largest element is");
	        System.out.println(result.get(size-2));
	 
	    }

}
