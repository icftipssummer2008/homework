package com.learning.algo.trees;

/**
 * Created by zakeer on 7/26/18.
 */

class NodeInfo {
    boolean isBST;
    int minValueInTree;
    int maxValueInTree;
    int size;
    Node root;

    public NodeInfo() {
        this.isBST = true;
        this.minValueInTree = Integer.MIN_VALUE;
        this.maxValueInTree = Integer.MAX_VALUE;
        this.size = 0;
        this.root = null;
    }

    public NodeInfo(boolean isBST, int minValueInTree, int maxValueInTree, int size, Node root) {
        this.isBST = isBST;
        this.minValueInTree = minValueInTree;
        this.maxValueInTree = maxValueInTree;
        this.size = size;
        this.root = root;
    }
}

public class LargestBSTInTree {
    protected Node largestBST(Node root) {
        NodeInfo info = largestBSTHelper(root);
        System.out.println("Size of Largest BST is :" + info.size);
        return info.root;
    }

    protected NodeInfo largestBSTHelper(Node root) {
        if(root == null) {
            return new NodeInfo();
        }

        NodeInfo leftNodeInfo = largestBSTHelper(root.left);
        NodeInfo rightNodeInfo = largestBSTHelper(root.right);
        NodeInfo info = new NodeInfo();
        // For leaf nodes
        if(leftNodeInfo.root == null && rightNodeInfo.root == null) {
            infoAssignment(true, root.value, root.value, 1, root ,info);
            return info;
        }

        // For all other nodes in tree
        if(leftNodeInfo.isBST && rightNodeInfo.isBST
                && (root.value > leftNodeInfo.maxValueInTree || leftNodeInfo.maxValueInTree == Integer.MAX_VALUE)
                && (root.value < rightNodeInfo.minValueInTree || rightNodeInfo.minValueInTree == Integer.MIN_VALUE)) {
            info.isBST = true;
            info.minValueInTree = Math.min(leftNodeInfo.maxValueInTree, root.value);
            info.maxValueInTree = Math.max(rightNodeInfo.minValueInTree,root.value);
            info.size = leftNodeInfo.size + rightNodeInfo.size + 1;
            info.root = root;
        }
        else {
            info.isBST = false;
            info.minValueInTree = Integer.MIN_VALUE;
            info.maxValueInTree = Integer.MAX_VALUE;
            info.size = Math.max(leftNodeInfo.size,rightNodeInfo.size);
            info.root = leftNodeInfo.size > rightNodeInfo.size ? leftNodeInfo.root : rightNodeInfo.root;
        }

        return info;
    }

    private void infoAssignment(boolean isBST, int minValueInTree, int maxValueInTree, int size, Node root, NodeInfo node) {
        node.isBST = isBST;
        node.minValueInTree = minValueInTree;
        node.maxValueInTree = maxValueInTree;
        node.size = size;
        node.root = root;
    }

    protected void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value);
        inOrderTraversal(root.right);
    }

}

class LargestBSTInTreeMain {
    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);

        root.left = new Node(6);
        root.left.left = new Node(7);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);

        root.right = new Node(12);
        root.right.left = new Node(9);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.right.right.right = new Node(16);
        root.right.right.right.right = new Node(17);

        LargestBSTInTree bstInfo = new LargestBSTInTree();
        bstInfo.inOrderTraversal(bstInfo.largestBST(root));
    }
}
