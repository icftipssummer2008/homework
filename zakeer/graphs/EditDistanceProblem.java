package com.learning.algo.graph;

import java.util.*;

/**
 * Created by zakeer on 8/2/18.
 */

class VertexInfo {
    List<String> path;
    String vertex;

    public VertexInfo(String vertex) {
        this.vertex = vertex;
        this.path = new ArrayList<>();
        this.path.add(vertex);
    }

    public VertexInfo(String vertex, List<String> path) {
        this.vertex = vertex;
        this.path = new ArrayList<>(path);
        this.path.add(vertex);
    }
}
public class EditDistanceProblem {

    Map<String, List<String>> adjList;

    public EditDistanceProblem() {
        this.adjList = new HashMap<>();
    }

    public EditDistanceProblem(String[] dictionary) {
        this.adjList = createAdjList(createWordSplitMap(dictionary));
    }

    public List<String> convert(String[] dictionary, String start, String end) {
        if(this.adjList.isEmpty()) {
            this.adjList = createAdjList(createWordSplitMap(dictionary));
        }
        // System.out.println(adjList.toString());
        // System.out.println("\n\n");
        // System.out.println(getMinPathFromStartToEnd(start, end).toString());

        return getMinPathFromStartToEnd(start, end);
    }

    private List<String> getMinPathFromStartToEnd(String start, String end) {
        List<String> minPathFromStartToEnd = new ArrayList<>();
        Set<String> isVisited = new HashSet<>();
        // for(Map.Entry<String, List<String>> entry: adjList.entrySet()) {
            if(!isVisited.contains(start)) {
                minPathFromStartToEnd = getMinPathFromStartToEndHelper(start, end, isVisited);
            }
        //}
        return minPathFromStartToEnd;
    }

    private List<String> getMinPathFromStartToEndHelper(String start, String end, Set<String> isVisited) {
        Queue<VertexInfo> q = new LinkedList<>();
        VertexInfo v = new VertexInfo(start);

        q.add(v);
        isVisited.add(v.vertex);

        while(!q.isEmpty()) {
            v = q.remove();
            if(v.vertex == end ) break;

            for(String neighbour: adjList.get(v.vertex)) {
                if(!isVisited.contains(neighbour)) {
                    q.add(new VertexInfo(neighbour, v.path));
                    isVisited.add(neighbour);
                }
            }

        }

        return v.path;
    }

    private Map<String, List<String>> createWordSplitMap(String[] dictionary) {
        Map<String,List<String>> wordSplitMap = new HashMap<>();
        for(String word: dictionary) {
            for(int i=0; i < word.length(); i++) {
                String splitWord = word.substring(0,i)
                        + word.substring(i+1,word.length());
                wordSplitMap.putIfAbsent(splitWord, new ArrayList<>());
                wordSplitMap.get(splitWord).add(word);
            }
        }
        // System.out.println(wordSplitMap.toString());
        return wordSplitMap;
    }

    private Map<String, List<String>> createAdjList(Map<String, List<String>> wordSplitMap) {
        Map<String,List<String>> graph = new HashMap<>();
        for(Map.Entry<String, List<String>> entry: wordSplitMap.entrySet()) {
            List<String> vertices = entry.getValue();
            for(int i=0; i< vertices.size(); i++ ) {
                List<String> adjVertices = new ArrayList<>(vertices);
                String vertex = adjVertices.remove(i);
                graph.putIfAbsent(vertex, new ArrayList<>());
                for(int j=0; j < adjVertices.size(); j ++ ) {
                    if(!graph.get(vertex).contains(adjVertices.get(j))) {
                        graph.get(vertex).add(adjVertices.get(j));
                    }
                }
            }
        }
        return graph;
    }
}

class EditDistanceProblemMain {
    public static void main(String[] args) {
        // String[] dictionay = {"cat", "bat", "hat", "bad", "had"};

        String[] dictionay =
        {
            "cat", "rat", "hat", "sag", "bag", "bug", "dog", "hog", "hot", "dot",
                    "rot", "lot", "log", "cry", "pry", "fry", "fat", "fog", "pot", "fat"
        };
        String source = "cat";
        String destination = "dog";

        EditDistanceProblem dist = new EditDistanceProblem();
        List<String> result = dist.convert(dictionay, source, destination);
        System.out.println(result.toString());
        System.out.println(dist.convert(dictionay,"lot", "fat").toString());
    }
}
