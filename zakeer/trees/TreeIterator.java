package com.learning.algo.trees;

import java.util.Stack;

/**
 * Created by zakeer on 7/16/18.
 */
public class TreeIterator {
    private Stack<Node> stack;

    public TreeIterator(Node root) {
        stack = new Stack<Node>();
        Node curr = root;
        while(curr != null ) {
            stack.push(curr);
            if (curr.left != null)
                curr = curr.left;
            else
                break;
        }
    }

    protected int next() {
        Node returnNode = stack.pop();
        Node currNode = returnNode;

        if(currNode.right != null ) {
            currNode = currNode.right;
            while(currNode != null ) {
                stack.push(currNode);
                if (currNode.left != null)
                    currNode = currNode.left;
                else
                    break;
            }
        }
        return returnNode.value;
    }

    protected boolean hasNext() {
        return !stack.isEmpty();
    }
}

class MainIterator {
    public static void main (String args[]) {
        Node root = null;
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        TreeIterator iterator = new TreeIterator(root);
        while(iterator.hasNext()) {
            System.out.println("Has Next: " + iterator.hasNext());
            System.out.println("Next: " + iterator.next());
        }
    }
}
