package com.learning.algo.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zakeer on 7/19/18.
 */
public class BTfromArray {

    static int preIndex = 0;
    public static void main (String args[] ) {
        int in[] = {4,2,1,5,3,6};
        int pre[] = {1,2,4,3,5,6};
        Node root = buildBT(in,pre);
        bfs(root);
    }

    public static Node buildBT(int in[], int pre[]) {
        return buildBT(in,pre,0,in.length-1);
    }

    public static Node buildBT(int in[], int pre[], int inStart, int inEnd) {
        if (inStart > inEnd ) return null;

        Node n = new Node(pre[preIndex]);
        int index = search(pre[preIndex], in);
        preIndex++;

        n.left = buildBT(in,pre,inStart,index-1);
        n.right = buildBT(in,pre,index+1, inEnd);

        return n;
    }

    private static int search(int value, int in[]) {
        for(int i=0; i<in.length; i++) {
            if(in[i] == value) return i;
        }
        return -1;
    }

    public static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.left != null) queue.offer(n.left);
            if(n.right != null) queue.offer(n.right);
            System.out.print(n.value + " --> ");
        }
    }
}
