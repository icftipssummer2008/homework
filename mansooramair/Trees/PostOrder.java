package com.amair.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PostOrder {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	static void postOrderTraversal(Node root) {
		Deque<Node> stack = new LinkedList<Node>();
		ArrayList<Integer>isChildVisited = new ArrayList<Integer>();
		
		if(root == null) return;
		stack.add(root);
		while(!stack.isEmpty()) {
			Node temp = stack.peek();
			if(!isChildVisited.contains(temp.data)) {
			if(temp.left!=null&&temp.right!=null) {
				stack.push(temp.right);
				stack.push(temp.left);
			}
			else if(temp.right!=null) {
				stack.push(temp.right);
			}
			else if(temp.left!=null) {
				stack.push(temp.left);
			}
			else {
				System.out.print(stack.pop().data+" ");
			}
			isChildVisited.add(temp.data);
			}
			else {
				System.out.print(stack.pop().data+" ");
			}
		}
	}
	static void postOrderRecursion(Node root) {
		if(root==null) return ;
		postOrderRecursion(root.left);
		postOrderRecursion(root.right);
		System.out.print(root.data+" ");
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
		
		postOrderTraversal(root);
		
		System.out.println();
		
		postOrderRecursion(root);
	}
	
}
