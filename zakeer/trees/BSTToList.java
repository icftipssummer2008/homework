package com.learning.algo.trees;

/**
 * Created by zakeer on 7/26/18.
 */
public class BSTToList {
    // <- 4 <-> 5 -> <-> <-7 <-> 8 ->
    private Node concatenate(Node a, Node b) {
        if(a == null ) return b;
        if(b == null ) return a;

        Node aLast = a.left;
        Node bLast = b.left;

        // connecting last element of 'a' with first element of b and viz.
        aLast.right = b;
        b.left = aLast;

        // Connecting last element of 'b' with first element of 'a' and viz
        a.left = bLast;
        bLast.right = a;

        return a;
    }

    protected Node treeToList(Node node) {
        if(node == null ) return node;

        Node leftList = treeToList(node.left);
        Node rightList = treeToList(node.right);

        node.left = node;
        node.right = node;

        return concatenate(concatenate(leftList, node),rightList);
    }

    protected void listTraversal(Node node) {
        Node head = node;
        if (head != null) {
            do {
                System.out.println(head.value);
                head = head.right;
            } while (head != node);
        }
    }
}

class BSTToListMain {
    public static void main(String args[]) {
        Node root = null;
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BSTToList bstToList = new BSTToList();
        Node list = bstToList.treeToList(root);
        bstToList.listTraversal(list);
    }
}