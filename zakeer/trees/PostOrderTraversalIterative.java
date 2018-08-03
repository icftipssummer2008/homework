package com.learning.algo.trees;

import java.util.Stack;

/**
 * Created by zakeer on 7/18/18.
 */
public class PostOrderTraversalIterative {
    protected Stack<Node> postOrderTraversal(Node root) {
        Stack<Node> temp = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();
        temp.push(root);

        while(!temp.isEmpty()) {
            Node n = temp.pop();
            output.push(n);
            if(n.left != null)
                temp.push(n.left);
            if(n.right != null)
                temp.push(n.right);
        }
        return output;
    }
}

class MainPostOrderTraversal {
    public static void main (String args[] ) {
        Node root = null;
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        PostOrderTraversalIterative pot = new PostOrderTraversalIterative();
        printStack(pot.postOrderTraversal(root));
    }

    private static void printStack(Stack<Node> stack) {
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }
}