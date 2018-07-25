package com.sohel.trees;

import java.util.Stack;



public class TreeIterative {
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeIterative tree = new TreeIterative();
		  
		tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
         
        System.out.println("PreOrder");

        tree.iterationPostOrder(tree.root);
        System.out.println("PreOrder");
        tree.iterationPreOrder(tree.root);
        System.out.println("InOrder");
        tree.iterationInOrder(tree.root);

	}
	
	private void iterationPostOrder(Node root){
	
		Stack S1 = new Stack();
		
		Stack S2 = new Stack();
		
		S1.push(root);
		
		while(!S1.isEmpty()) {
			Node temp = (Node) S1.pop();
			if(temp != null) {
				S2.push(temp);
			}
			if(temp.left != null) {
				S1.push(temp.left);
			}
			if(temp.right != null) {
				S1.push(temp.right);
			}
		}
		while(!S2.isEmpty()) {
			Node temp  = (Node) S2.pop();
			System.out.println(temp.key);
		}
	}
	

	private void iterationPreOrder(Node root){
	
		Stack S1 = new Stack();
				
		S1.push(root);
		
		while(!S1.isEmpty()) {
			Node temp = (Node) S1.pop();
			System.out.println(temp.key);
			
			if(temp.right != null) {
				S1.push(temp.right);
			}
			if(temp.left != null) {
				S1.push(temp.left);
			}
		}
	}
	
	private void iterationInOrder(Node root){
		
		Stack<Node> S = new Stack<>();
						
		while(true) {
			if(root != null) {
			S.push(root);
			root = root.left;
			}
			else {
				if(S.isEmpty()) break;
				root = S.pop();
				System.out.println(root.key);
				root = root.right;
			}
		}
	}
	
	
	
	

}
