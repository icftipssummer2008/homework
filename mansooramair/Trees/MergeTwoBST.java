package com.amair.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBST {
	 //ArrayList<Integer> arr= new ArrayList<Integer>();
	//static ArrayList<Integer> arr2;
	 static class Node{
		Node right;
		Node left;
		int val;
		Node(int val){
			this.val = val;
			right=left=null;
		}
	}
	
	public  static ArrayList<Integer> inOrderTrav(Node root,ArrayList<Integer> list){
		if (root==null) return list;
		inOrderTrav(root.left,list);
		if(root != null)  list.add(root.val);
		inOrderTrav(root.right,list);
		return list;
	}
	
	public static ArrayList<Integer> mergeTwoLists(ArrayList<Integer> list1 , ArrayList<Integer> list2){
		int i=0, j=0;
		int sizeOfList1 = list1.size();
		int sizeOfList2 = list2.size();
		ArrayList<Integer> mergeList = new ArrayList<Integer>();
		
		while(i<sizeOfList1 && j<sizeOfList2) {
			if(list1.get(i)<list2.get(j)) {
				mergeList.add(list1.get(i));
				i++;
			}
			else {
				mergeList.add(list2.get(j));
				j++;
			}
		}
		
		while(i<sizeOfList1) {
			mergeList.add(list1.get(i));
			i++;
		}
		while(j<sizeOfList2) {
			mergeList.add(list2.get(j));
			j++;
		}
		
		return mergeList;
	}
	
	public static Node buildTree(ArrayList<Integer> mergeList) {
		return helperBuildTree(mergeList,0,mergeList.size()-1);
	}

	public static Node helperBuildTree(ArrayList<Integer> mergeList , int start, int end) {
		if(start>end) return null;
		
		int mid = (start+end)/2;
		Node root = new Node(mergeList.get(mid));
		
		root.left = helperBuildTree(mergeList,start,mid-1);
		root.right = helperBuildTree(mergeList,mid+1,end);
		
		return root;
	}
	
	public static void printLevel(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if(root == null)  return;
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.val);
			if(temp.left!=null) q.add(root.left);
			if(temp.right!=null) q.add(root.right);
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MergeTwoBST merge = new MergeTwoBST();
		Node tree1 = new Node(2);
		tree1.left = new Node(1);
		tree1.right = new Node(3);
		
		Node tree2 = new Node(7);
		tree2.left = new Node(6);
		tree2.right = new Node(8);
		
		ArrayList<Integer> list1 = inOrderTrav(tree1,new ArrayList<Integer>());
		ArrayList<Integer> list2 = inOrderTrav(tree2,new ArrayList<Integer>());
		
		ArrayList<Integer> mergeList = mergeTwoLists(list1,list2);
		
		Node tree = buildTree(mergeList);
		
		ArrayList<Integer> list3 = inOrderTrav(tree,new ArrayList<Integer>());
		
		for(int i : list3) {
			System.out.println(i);
		}
		
		System.out.println("");
		System.out.println("Level Order Traversal:");
		printLevel(tree);
	
	}

}
