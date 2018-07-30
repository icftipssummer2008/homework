package com.amair.trees;

import java.util.ArrayList;

import com.amair.trees.PostOrder.Node;

public class ConstructTree {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	static int startindex=0;
	static ArrayList<Node> inorder = new ArrayList<Node>();
	static ArrayList<Node> preorder = new ArrayList<Node>();
	
	static Node constructTree(ArrayList<Node> inorder , ArrayList<Node> preorder) {
		if(preorder.isEmpty() || inorder.isEmpty()) return null;
		if (preorder.size() == inorder.size()) {
			return helpConstructTree(inorder,preorder,0,inorder.size()-1);
		}
		return null;
	}
	
	static Node helpConstructTree(ArrayList<Node> inorder , ArrayList<Node> preorder , int start, int end) {
		if(start>end) return null;
		Node root = preorder.get(startindex++);
		if(start==end) return root;
		int index = findIndex(inorder,root);
		//System.out.println("Indexes is : " + index);
		 root.left = helpConstructTree(inorder,preorder,start,index-1);
		 root.right = helpConstructTree(inorder,preorder,index+1,end);
		 return root;
	}
	
	static int findIndex(ArrayList<Node> inorder , Node root) {
	return inorder.indexOf(root);
	}
	
	static void inOrderTrav(Node root){
		if(root==null) return;
		inOrderTrav(root.left);
		inorder.add(root);
		inOrderTrav(root.right);
	}
	
	static void preOrderTrav(Node root){
		if(root==null) return;
		preorder.add(root);
		preOrderTrav(root.left);
		preOrderTrav(root.right);
		
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
		
		inOrderTrav(root);
		preOrderTrav(root);
		
/*		System.out.println("Before reconstruction Inorder");
		for(Node n : inorder) {
			System.out.print(n.data+" ");
		}
		System.out.println();
	
		System.out.println("Before reconstruction Pre Order");
		for(Node n : preorder) {
			System.out.print(n.data+" ");
		}
		System.out.println();*/
		
		Node reconstructroot = constructTree(inorder,preorder);
		inorder.clear();
		
		//System.out.println(reconstructroot.data);
		inOrderTrav(reconstructroot);
		System.out.println("After reconstruction");
		for(Node n : inorder) {
			System.out.print(n.data+" ");
		}
		System.out.println();
	}

}
