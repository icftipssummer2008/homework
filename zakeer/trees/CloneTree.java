package com.learning.algo.trees;

/**
 * Created by zakeer on 7/25/18.
 */
//class Node2 {
//    int value;
//    Node2 right;
//    Node2 left;
//
//    public Node2(int value) {
//        this.value = value;
//        this.right = null;
//        this.left = null;
//    }
//}

class CloneTreeMain {
    public static void main(String args[]) {
        Node root = null;
        root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.left.right.left = new Node(9);
        root.right = new Node(4);
        // root.right.left = new Node(5);
        root.right.right = new Node(7);

        inOrderTraversal(root);
        System.out.println();
        Node rootNew = clone(root);
        inOrderTraversal(rootNew);
    }

    public static Node clone(Node root) {
        if (root == null ) return null;

        Node node = new Node(root.value);

        node.left = clone(root.left);
        node.right = clone(root.right);

        return node;
    }

    protected static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value);
        inOrderTraversal(root.right);
    }
}
