package com.learning.algo.trees;

/**
 * Created by zakeer on 7/15/18.
 */
public class BST {
    protected boolean checkIfBTIsBST(Node node) {
        // Assuming the values of node in BT
        // can exists between min and max values
        int min = -9999, max = 9999;
        boolean result = checkIfBTIsBSTHelper(node, min, max);
        return result;
    }

    private boolean checkIfBTIsBSTHelper(Node node, int min, int max) {

        if (node == null) {
            return true;
        }

        if(min >= node.value || max < node.value)
            return false;
        boolean left = checkIfBTIsBSTHelper(node.left, min, node.value);
        System.out.println("At " + node.value);
        boolean right = checkIfBTIsBSTHelper(node.right, node.value, max);
        System.out.println("At " + node.value);
        return left && right;
    }

    private Node createABST() {
        Node root = null;
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        return root;
    }

    public static void main(String args[]) {
        System.out.println("In main()");
        BST bst = new BST();
        Node root = bst.createABST();
        if(bst.isValidBST(root))
            System.out.println("Is a BST");
        else
            System.out.println("Not a BST");
    }

    public boolean isValidBST(Node root) {
        Node prev = null;
        return isValidBST(root, prev);
    }

    private boolean isValidBST(Node root, Node prev) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left, prev)) {
            return false;
        }

        if (prev != null && root.value <= prev.value) {
            return false;
        }
        prev = root;

        return isValidBST(root.right, prev);
    }
}

