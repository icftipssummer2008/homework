package com.learning.algo.trees;

/**
 * Created by zakeer on 7/17/18.
 */
public class InvertTree {
    protected void flipTree(Node root) {
        if(root == null ) return;

        if(root.left == null && root.right == null ) return;

        // swap(root);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        flipTree(root.left);
        flipTree(root.right);
    }

    private void swap(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    protected void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value);
        inOrderTraversal(root.right);
    }
}

class MainInvertTree {
    public static void main (String args[] ) {
        Node root = null;
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        InvertTree tree = new InvertTree();
        tree.inOrderTraversal(root);
        tree.flipTree(root);
        System.out.println("\n\n");
        tree.inOrderTraversal(root);
    }
}
