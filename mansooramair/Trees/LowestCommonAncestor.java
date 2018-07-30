package com.amair.trees;

import java.util.ArrayList;
import com.amair.trees.BinaryTree.Node;

public class LowestCommonAncestor {
	static ArrayList<Integer> array1 = new ArrayList<Integer>();
	static ArrayList<Integer> array2 = new ArrayList<Integer>();
	
	static int findLowestCommonAncestor(Node root, Node n1, Node n2) {
		 findCompletePath(root,n1,array1);
		//findCompletePath(root,n2,array2);
		
		int i= array1.size();
		int j= array2.size();
		System.out.println(i + " " + j);
		int k = i<j?i:j;
		
		for(int m=0;m<k;m++) {
			if(array1.get(m)==array2.get(m)) {
				m++;
			}
			else {
				return array1.get(m-1);
			}
		}
		return -1;
	}
	
	static ArrayList<Integer> findCompletePath(Node root, Node n,ArrayList<Integer> array) {
		if(root==null) return null;
		array.add(root.data);
		System.out.println(root.data + ":" + n.data +":"+array);
		if(root.left!=null) {
			if(root.left.data == n.data) {
				System.out.println("Values are :" + array);
				array1.addAll(array);
				return array;
			}
			else findCompletePath(root.left,n,array);
		}
		else {
			return array;
		}
		array.remove(array.size()-1);
		if(root.right!=null) {
			if (root.right.data == n.data) return array;
			else findCompletePath(root.right,n,array);
		}
		else {
			return array; 
		}
		array.remove(array.size()-1);		
		return array;
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
		
		int lca = findLowestCommonAncestor( root, root.right.right , root.left);
		System.out.println("Lowest Common Ancestor: " + lca);
	}

}
