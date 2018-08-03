package com.learning.algo.trees;

/**
 * Created by zakeer on 7/15/18.
 */
public class PrintPathToLeave {
    public static void main (String[] args) {
        PrintPathToLeave tree = new PrintPathToLeave();
        Node root = tree.createTree();
        tree.printAllPathsToLeave(root);
    }

    private Node createTree() {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    private void printAllPathsToLeave(Node node) {
        System.out.println("Path from Root to leave nodes are as follows: ");
        printAllPathsToLeave(node, "");
    }

    private void printAllPathsToLeave(Node node, String soFar) {
        if(node == null) return;

        if(node.left == null && node.right == null ) {
            System.out.println("\t" + soFar + node.value);
            return;
        }

        printAllPathsToLeave(node.left, soFar + node.value);
        printAllPathsToLeave(node.right, soFar + node.value);
    }
}
