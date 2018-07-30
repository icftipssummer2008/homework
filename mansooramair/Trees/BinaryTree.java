package com.amair.trees;

public class BinaryTree {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	static boolean isBST(Node root) {
		if (root==null) return false;
		if(root.left==null&&root.right==null) return true;
		if(root.left==null) return isBST(root.right);
		if(root.right==null) return isBST(root.left);
		if((root.left.data<root.data) && (root.right.data>root.data)) {
			return isBST(root.left)&&isBST(root.right);
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(30);
		root.right = new Node(40);
		root.left = new Node(20);
		root.left.right=new Node(25);
		root.left.left = new Node(10);
		root.right.left = new Node(35);
		root.right.right = new Node(45);
		
		boolean isBST = isBST(root);
		System.out.println(isBST);
	}

}
