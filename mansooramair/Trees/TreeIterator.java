package com.amair.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TreeIterator {
	
	Deque<Node> stack = new LinkedList<Node>();
	ArrayList<Node> isleftnodevisited = new ArrayList<Node>();
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left=right=null;
		}
	}	
	TreeIterator(Node root){
		stack.push(root);
	}
	 boolean hasNext() {
		if(!stack.isEmpty()) return true;
		else return false;
	}
	int next() {
		while(hasNext()) {
			Node n1 = stack.peek();
			if(!isleftnodevisited.contains(n1)) {
				if(n1.left != null) {
					stack.push(n1.left);
					isleftnodevisited.add(n1);
				}
				else {
					return stack.pop().data;
				}
			}
			else {
				Node n2 = stack.pop();
				if(n2.right!=null) {
					stack.push(n2.right);
				}
				return n2.data;
			}
		}
		return 0;
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
		
		TreeIterator iterator = new TreeIterator(root);		
			
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
	}

}
