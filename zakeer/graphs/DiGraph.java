package com.learning.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by zakeer on 7/29/18.
 */
public class DiGraph {
    // Key as vertex and list of adjecent nodes as value
    HashMap<Integer, ArrayList<Integer>> adjList;

    public DiGraph(){
        adjList = new HashMap<>();
    }

    private void addNewVertex(int u) {
        adjList.putIfAbsent(u, new ArrayList<>());
        // adjList.put(u, new ArrayList<>());
    }

    protected void addEdge(int u, int v) {
        addNewVertex(u);
        addNewVertex(v);

        // Key u - value v
        adjList.get(u).add(v);
    }

    protected boolean isCycle() {
        HashSet<Integer> isVisited = new HashSet<>();
        HashSet<Integer> isAlive = new HashSet<>();
        for(Map.Entry<Integer, ArrayList<Integer>> vertex : adjList.entrySet()) {
            if(!isVisited.contains(vertex.getKey())) {
                return isCycle(vertex.getKey(),isVisited, isAlive);
            }
        }
        return false;
    }

    private boolean isCycle(int u, HashSet<Integer> isVisited,HashSet<Integer> isAlive) {
        isVisited.add(u);
        isAlive.add(u);

        for(int neighbour : adjList.get(u)) {
            if ((!isVisited.contains(neighbour) && isCycle(neighbour, isVisited, isAlive))
                    || (isVisited.contains(neighbour) && isAlive.contains(neighbour))) return true;
        }

        isAlive.remove(u);
        return false;
    }
}

class DiGraphMain {
    public static void main(String args[]) {
        DiGraph graph = new DiGraph();
        graph.addEdge(2,3);
        graph.addEdge(2,7);
        graph.addEdge(3,4);
        graph.addEdge(3, 6);
        graph.addEdge(5, 3);
        graph.addEdge(4,5);
        graph.addEdge(9, 8);

        if(graph.isCycle()) System.out.println("Is cycle");
        else System.out.println("Not cycle");
    }
}
