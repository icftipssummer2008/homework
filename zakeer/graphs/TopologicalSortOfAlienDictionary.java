package com.learning.algo.graph;

import java.util.*;

/**
 * Created by zakeer on 7/29/18.
 */
public class TopologicalSortOfAlienDictionary {
    private HashMap<Character, ArrayList<Character>> adjList;

    public TopologicalSortOfAlienDictionary() {
        adjList = new HashMap<>();
    }

    private void addVertex(char u) {
        adjList.putIfAbsent(u,new ArrayList<>());
    }

    private void addDirectedEdge(char u, char v) {
        this.addVertex(u);
        this.addVertex(v);

        // If v is not in list already, then add it
        if(!adjList.get(u).contains(v)) adjList.get(u).add(v);
    }

    protected HashMap<Character, ArrayList<Character>> getAdjList() {
        return this.adjList;
    }


    protected void orderedAlphabets(String orderedDictionary[]) {
        for(int i=0; i<orderedDictionary.length-1; i++) {
            createAdjList(orderedDictionary[i], orderedDictionary[i+1]);
        }
        for(char c: sortedAlphabets()) {
            System.out.println(c);
        }
    }

    private void createAdjList(String currentWord, String nextWord) {
        for(int i=0; i< Math.min(currentWord.length(),nextWord.length()); i++) {
            char u = currentWord.charAt(i);
            char v = nextWord.charAt(i);
            if(u!=v) {
                addDirectedEdge(u,v);
                break;
            }
        }
    }

    private Deque<Character> sortedAlphabets() {
        HashSet<Character> isVisited = new HashSet<>();
        Deque<Character> stack = new LinkedList<>();
        for(Map.Entry<Character, ArrayList<Character>> vertex: adjList.entrySet()) {
            if(!isVisited.contains(vertex.getKey())) {
                sortedAlphabets(vertex.getKey(), isVisited, stack);
            }
        }
        return stack;
    }

    private void sortedAlphabets(char u, HashSet<Character> isVisited, Deque<Character> stack) {
        isVisited.add(u);

        for(char neighbour: adjList.get(u)) {
            if(!isVisited.contains(neighbour))
                sortedAlphabets(neighbour, isVisited, stack);
        }
        stack.push(u);
    }
}


class TopologicalSortOfAlienDictionaryMain {
    public static void main(String args[]) {
        TopologicalSortOfAlienDictionary dict = new TopologicalSortOfAlienDictionary();
        String[] orderedDictionary = {"baa", "abcd", "abca", "cab", "cad"};
        dict.orderedAlphabets(orderedDictionary);
        System.out.println(dict.getAdjList().toString());
    }
}