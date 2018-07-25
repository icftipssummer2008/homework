package com.sohel.trees;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BFS {
		
		Node root;
		
	
		 public static void printBFS(Node root){
			 if(root == null) return;
			 Queue<Node> queue = new LinkedList<>();
			 queue.offer(root);
			 
			 while(!queue.isEmpty()) {
				 Node n = queue.poll();
				 System.out.println(n.key);
				 if(n.left != null)
					 queue.offer(n.left);
				 if(n.right!= null)
					 queue.offer(n.right);
			 }
				
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS tree = new BFS();
		  
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	  	       
	       
	            System.out.println("Print tree using BFS");
	            printBFS(tree.root);
	            
	            System.out.println("Print tree using DFS");
	            printDFS(tree.root);		      
	}

	private static void printDFS(Node root) {
		// TODO Auto-generated method stub
		 if(root == null) return;
		 Set<Integer> isVisited = new HashSet<>();
		 Stack<Node> S = new Stack<>();
		 S.push(root);
		 
	}

}
