package com.amair.trees;

public class CloneTree {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}	
	
	static Node cloneTree(Node root) {
		if(root==null) return null;
		Node cloneroot = new Node(root.data);
		cloneroot.left = cloneTree(root.left);
		cloneroot.right = cloneTree(root.right);
		return cloneroot;
	}
	
	static void inOrderTrav(Node root) {
		if(root==null) return;
		inOrderTrav(root.left);
		System.out.print(root.data + " ");
		inOrderTrav(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		Node clone =  cloneTree(root);
		
		inOrderTrav(clone);
	}

}
