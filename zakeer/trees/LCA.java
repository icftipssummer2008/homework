package com.learning.algo.trees;

/**
 * Created by zakeer on 7/16/18.
 */
public class LCA {

     protected Node findLCA(Node node, int value1, int value2) {
        if(node == null ) return null;

        // Check if the node's value is equal to value1 or value2
        if (node.value == value1 || node.value == value2 ) return  node;

        Node leftLca = findLCA(node.left, value1, value2);
        Node rightLca = findLCA(node.right, value1, value2);

         if(leftLca!=null &&  rightLca!=null) return node;

        return (leftLca != null ) ? leftLca : rightLca;
    }
}

class Main {
    public static void main(String args[]) {
        LCA lca = new LCA();
        Node root = createTree();
        Node lcaNode = lca.findLCA(root, 6,7);
        System.out.println("LCA: " + lcaNode.value);
    }

    private static Node createTree() {
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
}
