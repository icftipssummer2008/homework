package com.learning.algo.graph;

import java.util.*;

/**
 * Created by zakeer on 7/23/18.
 */
public class Graph {
    private HashMap<Integer,ArrayList<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public HashMap<Integer, ArrayList<Integer>> getAdjList() {
        return adjList;
    }

    public void addEdge(int u, int v) {
        // Add v -> u
        addEdgeHelper(u, v);
        // Add v -> u
        addEdgeHelper(v, u);
    }

    private void addEdgeHelper(int u, int v) {
        if(adjList.containsKey(u)) {
            adjList.get(u).add(v);
        }
        else {
            addVertex(u);
            adjList.get(u).add(v);
        }
    }

    private void addVertex(int u) {
        adjList.put(u, new ArrayList<>());
    }

    protected void printGraphUsingDfs() {
        HashSet<Integer> isVisited = new HashSet<>();
        boolean isNewGraph;
        for(Map.Entry<Integer, ArrayList<Integer>> vertex: adjList.entrySet()) {
            if(!isVisited.contains(vertex.getKey())) {
                isNewGraph = true;
                printGraphUsingDfs(vertex.getKey(), isVisited, isNewGraph);
            }
        }

    }

    private void printGraphUsingDfs(int key, HashSet<Integer> isVisited, boolean isNewGraph){
        isVisited.add(key);
        if (isNewGraph)
            System.out.print("\n" + key);
        else
            System.out.print(", " + key);
        ArrayList<Integer> value = adjList.get(key);
        for(int neighbour: value) {
            if(!isVisited.contains(neighbour)) printGraphUsingDfs(neighbour, isVisited, false);
        }
    }

    protected  void printGraphUsingBfs() {
        HashSet<Integer> isVisited = new HashSet<>();
        boolean isNewGraph;
        for(Map.Entry<Integer, ArrayList<Integer>> vertex: adjList.entrySet()) {
            if(!isVisited.contains(vertex.getKey())) {
                isNewGraph = true;
                printGraphUsingBfs(vertex.getKey(), isVisited, isNewGraph);
            }
        }
    }

    private void printGraphUsingBfs(int key, HashSet<Integer> isVisited, boolean isNewGraph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(key);
        isVisited.add(key);

        while(!q.isEmpty()) {
            int valueFromQueue = q.poll();
            if(isNewGraph) {
                System.out.print("\n" + valueFromQueue);
                isNewGraph = false;
            }
            else {
                System.out.print(", " + valueFromQueue);
            }

            for(int value: adjList.get(valueFromQueue)) {
                if(!isVisited.contains(value)) {
                    q.offer(value);
                    isVisited.add(value);
                }
            }
        }
    }
}

class GraphMain {
    public static void main(String args[]) {
        Graph graph = new Graph();
        graph.addEdge(2,3);
        graph.addEdge(2,7);
        graph.addEdge(3,4);
        graph.addEdge(3,6);
        graph.addEdge(3,5);
        graph.addEdge(9, 8);
        System.out.print("DFS is as follows: ");
        graph.printGraphUsingDfs();
        System.out.println("\n");
        System.out.print("BFS is as follows: ");
        graph.printGraphUsingBfs();
    }
}
