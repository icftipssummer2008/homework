package com.amair.trees;

import java.util.ArrayList;

import com.amair.trees.BinaryTree.Node;

public class CompletePath {
	static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	static void completePath(Node root) {
		if (root==null) return;
		arrayList.add(root.data);
		if(root.left != null) {
			completePath(root.left);
		}
		else {
			printPath(arrayList);
			return;
		}
		arrayList.remove(arrayList.size()-1);
		if(root.right!=null) {
			completePath(root.right);
		}	
		else {
			printPath(arrayList);
			return;
		}
		arrayList.remove(arrayList.size()-1);
	}
	static void printPath(ArrayList<Integer> arrayList) {
		for(int i:arrayList) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.right = new Node(3);
		root.left = new Node(2);
		root.left.right=new Node(5);
		root.left.left = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		completePath(root);
	}

}
